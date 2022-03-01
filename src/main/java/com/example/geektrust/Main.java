package com.example.geektrust;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.example.geektrust.ExpenseManagement.dao.House;
import com.example.geektrust.ExpenseManagement.dao.Property;
import com.example.geektrust.ExpenseManagement.utils.FileUtils;
import com.example.geektrust.command.domain.CommandProcessor;
import com.example.geektrust.command.factory.CommandFactory;

public class Main {
    public static void main(String[] args) throws IOException  {
	 
    	String path ="D://sampleIO.txt";//args[0];
    	Collection<String> cmds   = FileUtils.parseLinesFromaFile(path);
    	Property prop = new House(Thread.currentThread().getName());
    	CommandFactory cmd = new CommandFactory();
    	final CommandProcessor cmdP ;
    	try {
			cmdP = cmd.getCommandProcessor(null);
			for(String line : cmds) {
				 System.out.println(cmdP.performCommand(prop, line).getValue());
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
	}
}
