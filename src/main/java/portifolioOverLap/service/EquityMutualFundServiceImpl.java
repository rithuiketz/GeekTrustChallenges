package portifolioOverLap.service;

import java.util.Collection;
import java.util.Optional;

import static portifolioOverLap.factory.InstrumentationServiceFactory.getInstrumentationService;

import portifolioOverLap.data.MutualFundDataStore;
import portifolioOverLap.exceptions.InstrumentException.InstrumentAlreadyMappedException;
import portifolioOverLap.exceptions.InstrumentException.InstrumentDoesntExistsException;
import portifolioOverLap.exceptions.InstrumentException.InstrumentExistsException;
import portifolioOverLap.exceptions.DataStoreException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundExistsException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundNotExistsException;
import portifolioOverLap.factory.InstrumentationServiceFactory;
import portifolioOverLap.pojo.EquityMutualFund;
import portifolioOverLap.pojo.Instrument;
import portifolioOverLap.pojo.MutualFund;

public class EquityMutualFundServiceImpl implements MutualFundService {

	String stockServiceType = InstrumentationServiceFactory.STOCK_SERVICE_TYPE;

	@Override
	public double calculateOverLap(String mf1, String mf2) throws MutualFundNotExistsException 
	{
		
		Optional<MutualFund> mutualFund1 = MutualFundDataStore.getInstance().get(mf1);
		Optional<MutualFund> mutualFund2 = MutualFundDataStore.getInstance().get(mf2);
		
		if(!mutualFund1.isPresent())
		{
			throw new MutualFundNotExistsException(mf1);
		}
		
		if(!mutualFund2.isPresent())
		{
			throw new MutualFundNotExistsException(mf1);
		}
		
		
		
		Collection<Instrument> mf1Ins =  mutualFund1.get().getAllInstruments();
		Collection<Instrument> mf2Ins =  mutualFund2.get().getAllInstruments();
		
		double mf1Count =  mf1Ins.stream().count();
		double mf2Count =  mf2Ins.stream().count();
				
		double commonCount = mf1Ins.stream().filter(obj -> mf2Ins.contains(obj)).count();
				
		return  2*(commonCount)/ (mf1Count+mf2Count) * 100;
		
	}

	@Override
	public Collection<MutualFund> getAllMutualFunds() 
	{
		return MutualFundDataStore.getInstance().list();
	}

	@Override
	public void addInstrument(String mutualFundName, String instrument) throws InstrumentAlreadyMappedException,MutualFundNotExistsException 
	{
		Optional<MutualFund> mutualFund = MutualFundDataStore.getInstance().get(mutualFundName);
		if(!mutualFund.isPresent())
		{
			throw new MutualFundNotExistsException();
		}
		
		
		Instrument is = null;
		try 
		{
			getInstrumentationService(stockServiceType).save(instrument);
		} 
		catch(InstrumentExistsException iex)
		{
			//System.out.println(iex.getMessage());
		}
		
		try {
			is = getInstrumentationService(stockServiceType).read(instrument);
		} catch (InstrumentDoesntExistsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		mutualFund.get().addStockToFund(is);
		
	}

	@Override
	public void createMf(String mfName) throws MutualFundExistsException {
		Optional<MutualFund> mutualFund = MutualFundDataStore.getInstance().get(mfName);
		if (mutualFund.isPresent()) {
			throw new MutualFundExistsException();
		}
		MutualFund mf = new EquityMutualFund(mfName);
		
		try {
			MutualFundDataStore.getInstance().save(mfName, mf);
		} catch (DataStoreException de) {
			
		}
	}

	@Override
	public Optional<MutualFund> getFundByName(String name) {
		 
		return MutualFundDataStore.getInstance().get(name);
	}

}
