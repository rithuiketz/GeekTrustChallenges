package portifolioOverLap.data;

import java.util.Collection;
import java.util.Optional;


import portifolioOverLap.exceptions.DataStoreException;

public interface DataStore<T,K> 
{
	
	public boolean save(K key,T object) throws DataStoreException;
	
	public Optional<T> get(K key);
	
	public boolean delete(K key) throws DataStoreException;
	
	public Collection<T> list();

}
