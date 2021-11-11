package portifolioOverLap.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import portifolioOverLap.exceptions.DataStoreException;
import portifolioOverLap.pojo.Instrument;


public final class InstrumentDataStore implements DataStore<Instrument,String>
{
	private Map<String,Instrument> map = new HashMap<>();
	
	private static volatile InstrumentDataStore instrumentDataStore = null;
	
	private InstrumentDataStore() {
		super();
	}
	
	
	public static InstrumentDataStore getInstance()
	{
		if(instrumentDataStore == null)
		{
			synchronized (InstrumentDataStore.class) 
			{
				if(instrumentDataStore == null)
				{
					instrumentDataStore =  new InstrumentDataStore();
				}
			}
		}
		return instrumentDataStore;
	}
	
	@Override
	public boolean delete(String key) throws DataStoreException {
		map.remove(key);
		return true;
	}
	
	@Override
	public Collection<Instrument> list() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
	@Override
	public Optional<Instrument> get(String key) {
		// TODO Auto-generated method stub
		if(map.containsKey(key)) {
			return Optional.of(map.get(key));
		}
	    return Optional.empty();
	}
	
	@Override
	public boolean save(String key, Instrument object) throws DataStoreException {
		if(object == null)
			throw new DataStoreException("Null Values can't be Stored");
		else if(map.containsKey(key))
			throw new DataStoreException("Instrument "+key+" Exists Already");
		map.putIfAbsent(key, object);
		return true;
	}
}
	
