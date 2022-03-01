package com.example.geektrust.ExpenseManagement.dao;

import java.util.Collection;

import com.example.geektrust.ExpenseManagement.utils.StatusEnum;

public interface Property 
{
	public  String getPropertyIdNo();
	
	public StatusEnum addMemeber(Person person);
	
	public StatusEnum removeMemeber(Person person);
	
	public StatusEnum addExpense(double amount,String borrowerName,Collection<String> lenders);
	
	public Collection<Expense> getExpenses();
	
	public Collection<Person> getMembers();

	
}
