package com.example.geektrust.command.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.command.domain.CommandProcessor;

public class CommandFactory 
{
	private static Map<String,CommandProcessor> serviceRegistery = new HashMap<>();
	
	
	public CommandProcessor getCommandProcessor(String className) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException 
	{
		
		if(className == null || className.trim().length() ==0)
		{
			className= "com.example.geektrust.command.domain.BasicCommandProcessor";
		}
		
		if(!serviceRegistery.containsKey(className)) 
		{
			
			CommandProcessor cmdp = (CommandProcessor) Class.forName(className).getDeclaredConstructor().newInstance();
			serviceRegistery.put(className, cmdp);
		}
		return serviceRegistery.get(className);
		
		
		
	}
	
}
