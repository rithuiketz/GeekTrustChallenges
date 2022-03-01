package com.example.geektrust.ExpenseManagement.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.geektrust.ExpenseManagement.utils.PropertyKeys;
import com.example.geektrust.ExpenseManagement.utils.PropertyUtils;
import com.example.geektrust.ExpenseManagement.utils.StatusEnum;

public class House implements Property {

	private Set<Person> members = new HashSet<Person>();

	private List<Expense> expenses = new ArrayList<>();

	private String houseNum;

	public House(String houseNum) {
		this.houseNum = houseNum;
	}

	@Override
	public String getPropertyIdNo() {
		// TODO Auto-generated method stub
		return this.houseNum;
	}

	public int getMaxMembersAllowed() {

		int maxAllowed = 0;
		Optional<String> maxMembers = PropertyUtils.getProperty(PropertyKeys.KEY_HOUSE_MAX_NUM_ALLOWED.getValue());
		if (maxMembers.isPresent()) {
			try {
				maxAllowed = Integer.parseInt(maxMembers.get());
			} catch (Exception exec) {
				exec.printStackTrace();
			}
		}
		return maxAllowed;
	}

	@Override
	public StatusEnum addMemeber(Person person) {
		if (person == null) {
			return StatusEnum.INVALID_MEMBER;
		}
		if (members.contains(person)) {
			return StatusEnum.DUPLICATE_MEMBER;
		}
		if (members.size() >= this.getMaxMembersAllowed()) {
			return StatusEnum.HOUSEFUL;
		} else {
			members.add(person);
			return StatusEnum.SUCCESS;
		}
	}

	@Override
	public StatusEnum removeMemeber(Person person) {

		if (members.isEmpty() || !members.contains(person)) {
			return StatusEnum.MEMBER_NOT_FOUND;
		}
		return StatusEnum.OK;
	}


	@Override
	public StatusEnum addExpense(double amount, String borrowerName, Collection<String> lendersNames) {
		
		Person borrower = new PersonImpl(borrowerName);
		
		if (members.isEmpty() || !members.contains(borrower)) {
			return StatusEnum.MEMBER_NOT_FOUND;
			
		}
		
		
		for(String lender :lendersNames)
		{

			Person lenderObj = new PersonImpl(lender);

			if (members.contains(lenderObj)) 
			{
				this.expenses.add(new ExpenseImpl(amount / (lendersNames.size()+1), borrower, lenderObj));
			}
			else
			{
				return StatusEnum.MEMBER_NOT_FOUND;
			}
			

		};

		
		return StatusEnum.SUCCESS ;
	}

	@Override
	public Collection<Expense> getExpenses() {
		// TODO Auto-generated method stub
		return this.expenses;
	}

	@Override
	public Collection<Person> getMembers() {
		// TODO Auto-generated method stub
		return this.members;
	}

}
