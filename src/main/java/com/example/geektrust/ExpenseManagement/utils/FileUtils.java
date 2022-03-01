package com.example.geektrust.ExpenseManagement.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;


public class FileUtils 
{
	public static Collection<String> parseLinesFromaFile(String path) throws IOException
	{
		Collection<String> coll = new ArrayList<String>();
		Reader is = null;
		BufferedReader bis = null;
		try {
			is = new FileReader(path);
			bis = new BufferedReader(is);
		    while(bis.ready())
		    {
		    	coll.add(bis.readLine());
		    }
			
		}
		catch(IOException ioex)
		{
			ioex.printStackTrace();
			throw ioex;
		}
		finally
		{
			try {
				is.close();
				bis.close();
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}
		
		return coll;
	}
}
