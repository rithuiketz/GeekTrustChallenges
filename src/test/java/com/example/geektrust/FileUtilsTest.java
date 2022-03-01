package com.example.geektrust;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.example.geektrust.ExpenseManagement.utils.FileUtils;

@TestMethodOrder(OrderAnnotation.class)
class FileUtilsTest {
	
	/**
	 * 
	 * @throws IOException
	 */

	@Test
	@Order(1)
	void testForFIleThatExists() 
	{
		try
		{
			String path="D://sampleIO.txt";
			Collection<String> strs = FileUtils.parseLinesFromaFile(path);
			assertTrue((strs !=null) && strs.size() > 0);

		}
		catch(Exception e)
		{
			assertFalse(true);
		}
	}
	@Test
	@Order(2)
	void testForFIleThatNotExists() throws IOException 
	{
		String path="D://sampleIO2.txt";
		try {
			Collection<String> strs = FileUtils.parseLinesFromaFile(path);
			assertFalse(true);
		}
		catch(Exception e)
		{
			if(! (e instanceof IOException))
			{
				assertFalse(true);
			}
			assertTrue(true);
		}
	}

}
