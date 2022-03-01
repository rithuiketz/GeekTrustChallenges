package com.example.geektrust.ExpenseManagement.utils;

public enum PropertyKeys 
{
	KEY_HOUSE_MAX_NUM_ALLOWED("geektrust.expensemgmt.house.maxNumAllowed");
	
	
	private String value;

	private PropertyKeys(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
	
}
