package portifolioOverLap.factory;

import portifolioOverLap.service.InstrumentService;
import portifolioOverLap.service.StockServiceImpl;

public class InstrumentationServiceFactory {
	public static final String STOCK_SERVICE_TYPE = "stock";

	// As of now we are using only stocks as investment instrument this can be
	// extend in future with multiple instruments and services
	public static InstrumentService getInstrumentationService(String service) 
	{
		if (STOCK_SERVICE_TYPE.equals(service))
			return new StockServiceImpl();
		return null;

	}

}
