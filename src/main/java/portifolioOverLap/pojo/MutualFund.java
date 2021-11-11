package portifolioOverLap.pojo;

import java.util.Collection;

public interface MutualFund 
{
	public String getName();
	
	public Collection<Instrument> getAllInstruments();
	
	public void addStockToFund(Instrument instrument);
}
