package com.example.geektrust;



import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.geektrust.ExpenseManagement.utils.PropertyKeys;
import com.example.geektrust.ExpenseManagement.utils.PropertyUtils;

import junit.framework.Assert;

class PropertyTest {

	@Test
	/*
	 * test to find a property loading from application.props
	 */
	public void testPropertyCheck()
	{
	   Optional<String> optnl = PropertyUtils.getProperty(PropertyKeys.KEY_HOUSE_MAX_NUM_ALLOWED.getValue());
	   if(optnl.isPresent())
		   Assert.assertTrue(true);
	   else
		   Assert.assertFalse(true);
	}

}
