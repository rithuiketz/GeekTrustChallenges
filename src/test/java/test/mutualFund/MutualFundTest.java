package test.mutualFund;




import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

import portifolioOverLap.exceptions.InstrumentException.InstrumentAlreadyMappedException;
import portifolioOverLap.exceptions.MutualFundException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundExistsException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundNotExistsException;
import portifolioOverLap.factory.MutalFundServiceFactory;


@TestMethodOrder(OrderAnnotation.class)
public class MutualFundTest
{

	
	@Test
	@Order(1)
	public void testCreation() throws InstrumentAlreadyMappedException, MutualFundExistsException
	{
		//MutalFundServiceFactory.getMfService("equity").createMf("test1");
		
	}
	
	@Test
	@Order(2)
	public void testUpdate() throws InstrumentAlreadyMappedException, MutualFundNotExistsException
	{
		//MutalFundServiceFactory.getMfService("equity").addInstrument("test1", "test2");
	}
	
	@Test
	@Order(3)
	public void testDuplicate() 
	{
		/*
		 * try { MutalFundServiceFactory.getMfService("equity").createMf("test1" ); }
		 * catch(Exception e) { assertTrue(e instanceof MutualFundExistsException); }
		 */
	}
	
	

}
