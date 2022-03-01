package com.example.geektrust.ExpenseManagement.dao;



public class ExpenseImpl implements Expense 
{
    private Double amount;
	
    private Person whoSpent;
    
    private Person toWhomSpent;
	
	public ExpenseImpl(double amount, Person whoSpent, Person toWhomSpent) {
		super();
		this.amount = amount;
		this.whoSpent = whoSpent;
		this.toWhomSpent = toWhomSpent;
	}

	@Override
	public Person getWhoSpent() {
		// TODO Auto-generated method stub
		return this.whoSpent;
	}

	@Override
	public Person getToWhomSpent() {
		// TODO Auto-generated method stub
		return this.toWhomSpent;
	}

	@Override
	public Double getAmountSpent() {
		// TODO Auto-generated method stub
		return this.amount;
	}

}
