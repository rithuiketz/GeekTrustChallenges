package portifolioOverLap.service;

import java.util.Collection;
import java.util.Optional;

import portifolioOverLap.exceptions.InstrumentException.InstrumentAlreadyMappedException;
import portifolioOverLap.exceptions.MutualFundException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundExistsException;
import portifolioOverLap.exceptions.MutualFundException.MutualFundNotExistsException;
import portifolioOverLap.pojo.MutualFund;

public interface MutualFundService 
{
	
	public void createMf(String mfName) throws MutualFundExistsException;
	
	public void addInstrument(String mutualFund,String instrument) throws InstrumentAlreadyMappedException,MutualFundNotExistsException ;
	
	public double calculateOverLap(String mf1,String mf2) throws MutualFundNotExistsException;
	
	public Collection<MutualFund> getAllMutualFunds();
	
	public Optional<MutualFund> getFundByName(String name);
	
	
}
