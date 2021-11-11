package test.instrument;




import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import portifolioOverLap.exceptions.InstrumentException.InstrumentDoesntExistsException;
import portifolioOverLap.exceptions.InstrumentException.InstrumentExistsException;
import portifolioOverLap.factory.InstrumentationServiceFactory;
import portifolioOverLap.pojo.Instrument;
@TestMethodOrder(OrderAnnotation.class)
public class InstrumentTest {

	

	@Test
	@Order(4)
	public void testStockCreation() throws InstrumentExistsException {
		System.out.println("Test 1....");
		//InstrumentationServiceFactory.getInstrumentationService("stock").save("test");
	}

	@Test
	@Order(5)
	public void testStockRead() throws InstrumentDoesntExistsException{
	{
		System.out.println("Test 2....");
		//Instrument ins = InstrumentationServiceFactory.getInstrumentationService("stock").read("test");
		//assert(ins!=null);
		
	}
	

}
}
