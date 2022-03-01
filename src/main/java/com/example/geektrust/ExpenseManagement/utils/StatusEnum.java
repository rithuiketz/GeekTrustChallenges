package com.example.geektrust.ExpenseManagement.utils;

public enum StatusEnum 
{
	DUPLICATE_MEMBER("DUPLICATE_MEMBER"), MEMBER_NOT_FOUND("MEMBER_NOT_FOUND"),MEMBER_ADDED("MEMBER_ADDED_TO_HOUSE"),CLEAR_DUE("CLEAR_DUE"),
	INVALID_MEMBER("INVALID_MEMBER"),HOUSEFUL("HOUSEFUL"),OK("OK"),EMPTY(""),SUCCESS("SUCCESS");

	private String value;

	public String getValue() {
		return value;
	}

	private StatusEnum(String value) {
		this.value = value;
	}

}
