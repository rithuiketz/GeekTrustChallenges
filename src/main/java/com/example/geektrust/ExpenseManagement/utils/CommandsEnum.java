package com.example.geektrust.ExpenseManagement.utils;

public enum CommandsEnum 
{
	MOVE_IN("MOVE_IN"), CLEAR_DUE("CLEAR_DUE"), SPEND("SPEND"), MOVE_OUT("MOVE_OUT"), DUES("DUES");

	private String value;

	public String getValue() {
		return value;
	}

	private CommandsEnum(String value) {
		this.value = value;
	}

}
