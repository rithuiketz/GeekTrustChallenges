package portifolioOverLap.pojo;

import java.util.Collection;

/**
 * Instrument can be any stock bond or anything where MFs can invest
 * @author ry123809
 *
 */
public interface Instrument 
{
	public String getInstrumentName();
	
	public Collection<MutualFund> getAllMfsInvested();

}
