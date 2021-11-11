package portifolioOverLap.factory;

import portifolioOverLap.service.EquityMutualFundServiceImpl;
import portifolioOverLap.service.MutualFundService;

public class MutalFundServiceFactory {
	public static final String EQUITY_MF_SERVICE_TYPE = "equity";

	// As of now we are using only equity mfs this can be
	// extend in future with multiple mfs like elss etc and services
	
	public static MutualFundService getMfService(String service) {
		if (EQUITY_MF_SERVICE_TYPE.equals(service))
			return new EquityMutualFundServiceImpl();
		return null;

	}

}
