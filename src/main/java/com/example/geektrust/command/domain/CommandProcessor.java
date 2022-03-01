package com.example.geektrust.command.domain;

import com.example.geektrust.ExpenseManagement.dao.Property;
import com.example.geektrust.ExpenseManagement.utils.StatusEnum;

public interface CommandProcessor 
{
	public StatusEnum performCommand(Property property,String line);
}
