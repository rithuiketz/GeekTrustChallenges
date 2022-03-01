package com.example.geektrust.ExpenseManagement.dao;



public interface Expense 
{
	public Person getWhoSpent();
	
	public Person getToWhomSpent();
	
	public Double getAmountSpent();
	

}
