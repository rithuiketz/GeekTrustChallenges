package com.example.geektrust.command.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.example.geektrust.ExpenseManagement.dao.Expense;
import com.example.geektrust.ExpenseManagement.dao.Person;
import com.example.geektrust.ExpenseManagement.dao.PersonImpl;
import com.example.geektrust.ExpenseManagement.dao.Property;
import com.example.geektrust.ExpenseManagement.utils.CommandsEnum;
import com.example.geektrust.ExpenseManagement.utils.StatusEnum;

public class BasicCommandProcessor implements CommandProcessor {

	@Override
	public StatusEnum performCommand(Property prop, String line) {
		String[] cmds = line.split(" ");
		String action = cmds[0];
		if (action != null) {
			if (CommandsEnum.MOVE_IN.getValue().equals(action)) {
				return handleMoveIn(prop, cmds);
			} else if (CommandsEnum.MOVE_OUT.getValue().equals(action)) {
				//return handleMoveout(prop, cmds);
			} else if (CommandsEnum.SPEND.getValue().equals(action)) {
				return handleSpend(prop, line);
				
			} else if (CommandsEnum.DUES.getValue().equals(action)) {
				return  handleDues(prop, line);
				
			}

		}
		return StatusEnum.EMPTY;
	}

	private StatusEnum handleDues(Property prop, String line) {
		String person = line.split(" ")[1];
		Person p = new PersonImpl(person);
		if(!prop.getMembers().contains(p))
		{
			return StatusEnum.MEMBER_NOT_FOUND;
		}
		findAllDuesOFPerson(prop, p);
		return StatusEnum.EMPTY;
	}

	private void findAllDuesOFPerson(Property prop, Person dueChecker) 
	{

	    Collection<Person> people =prop.getMembers();
	    Collection<Expense> expenses  = prop.getExpenses();
	   	    	    
	    Map<Person,Double> map = new HashMap<Person, Double>();
	    
	    
	    people.forEach(person ->
	    {
	    	List<Expense> personOwed = expenses.stream().filter(expen-> !(expen.getWhoSpent().equals(dueChecker)))
	    			.filter(expen -> expen.getWhoSpent().equals(person))
	    			.filter(expen -> expen.getToWhomSpent().equals(dueChecker)).collect(Collectors.toList());
	    	
	    			
	    	Double amount =  personOwed.stream().mapToDouble(expn -> expn.getAmountSpent()).reduce(0, Double::sum);		
	    	if(!person.equals(dueChecker))
	    	{
	    		System.out.println(person.getName()+" "+amount);
	    		map.put(person, amount); 
	    	}
	    	   	
	    	
	    });
	    
		Comparator<Expense> cmp = (Expense e1, Expense e2) -> {
			
			if(e1.getAmountSpent() ==e2.getAmountSpent())
			{
				return e1.getWhoSpent().getName().compareTo( e2.getWhoSpent().getName());
			}
			else
			{
				return e2.getAmountSpent().compareTo(e2.getAmountSpent());
			}
		};
	
		
	}

	private StatusEnum handleSpend(Property prop, String cmd) {
		String[] arr = cmd.split(" ", 4);
		double amount = Double.parseDouble(arr[1]);
		String borrower = arr[2];
		List<String> lenders = Arrays.asList(arr[3].split(" "));
		return prop.addExpense(amount, borrower, lenders);

	}

	private StatusEnum handleMoveIn(Property prop, String[] cmds) {

		String pName = cmds[1];
		Person per = new PersonImpl(pName);
		return prop.addMemeber(per);

	}

	private StatusEnum handleMoveout(Property prop, String[] cmds) {

		String pName = cmds[1];
		Person per = new PersonImpl(pName);
		return prop.removeMemeber(per);

	}

}
