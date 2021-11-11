package portifolioOverLap.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import portifolioOverLap.exceptions.DataStoreException;
import portifolioOverLap.pojo.MutualFund;

public class MutualFundDataStore implements DataStore<MutualFund, String> 
{

	private Map<String,MutualFund> map = new LinkedHashMap<>();
	
	private static volatile MutualFundDataStore mfDataStore = null;
	
	private MutualFundDataStore() {
		super();
	}
	
	
	public static MutualFundDataStore getInstance()
	{
		if(mfDataStore == null)
		{
			synchronized (MutualFundDataStore.class) 
			{
				if(mfDataStore == null)
				{
					mfDataStore =  new MutualFundDataStore();
				}
			}
		}
		return mfDataStore;
	}
	
	@Override
	public boolean delete(String key) throws DataStoreException {
		map.remove(key);
		return true;
	}
	
	@Override
	public Collection<MutualFund> list() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
	@Override
	public Optional<MutualFund> get(String key) {
		if(map.containsKey(key)) {
			return Optional.of(map.get(key));
		}
		return Optional.empty();
	}
	
	@Override
	public boolean save(String key, MutualFund object) throws DataStoreException {
		if(object == null)
			throw new DataStoreException("Null Values can't be Stored");
		else if(map.containsKey(key))
			throw new DataStoreException("Instrument "+key+" Exists Already");
		map.putIfAbsent(key, object);
		return true;
	}


}
