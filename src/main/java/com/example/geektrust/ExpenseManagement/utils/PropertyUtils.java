package com.example.geektrust.ExpenseManagement.utils;


import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertyUtils 
{
	private static final Properties properties =  new Properties();
	
	static {
		try {
			reloadProps();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void reloadProps() throws Exception
	{
		try
		{
			InputStream rsrc = PropertyUtils.class.getClassLoader().getResourceAsStream("application.properties");
			properties.load(rsrc);
			
		}
		catch(Exception exec)
		{
			throw exec;
		}
	}
	
	public static Optional<String> getProperty(String key)
	{
		 return Optional.of(properties.getProperty(key));
	}
	
	
}
