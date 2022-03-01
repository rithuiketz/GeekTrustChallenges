package com.example.geektrust.ExpenseManagement.dao;

import java.security.InvalidParameterException;

public class PersonImpl implements Person
{
	private String personName;

	public PersonImpl(String personName) {
		super();
		if(personName == null || personName.trim().length() ==0)
		{
			throw new  InvalidParameterException("Invalid Person Name");
		}
		
		this.personName = personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.personName;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.personName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof Person))
		{
			return false;
		}
		else
		{
			Person  p = (Person) obj;
			return this.hashCode() ==  p.hashCode();
		}
		
	}
	private PersonImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ Person : "+this.personName+" }";
	}
	

}
