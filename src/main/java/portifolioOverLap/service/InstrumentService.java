package portifolioOverLap.service;

import java.util.Collection;


import portifolioOverLap.exceptions.InstrumentException;
import portifolioOverLap.exceptions.InstrumentException.InstrumentDoesntExistsException;
import portifolioOverLap.pojo.Instrument;

public interface InstrumentService 
{
	
	public void save(String name) throws InstrumentException.InstrumentExistsException;
	
	public Collection<Instrument> list();
	
	public Instrument read(String name) throws InstrumentDoesntExistsException;
}
