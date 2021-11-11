package portifolioOverLap.service;

import java.util.Collection;
import java.util.Optional;

import portifolioOverLap.data.InstrumentDataStore;
import portifolioOverLap.exceptions.DataStoreException;
import portifolioOverLap.exceptions.InstrumentException;
import portifolioOverLap.exceptions.InstrumentException.InstrumentDoesntExistsException;
import portifolioOverLap.pojo.Instrument;
import portifolioOverLap.pojo.Stock;

public class StockServiceImpl implements InstrumentService {

	@Override
	public void save(String name) throws InstrumentException.InstrumentExistsException {

		InstrumentDataStore ds = InstrumentDataStore.getInstance();
		Optional<Instrument> is = ds.get(name);
		if (!is.isPresent()) {
			Stock stock = new Stock(name);
			try {
				ds.save(name, stock);
				return;
			} catch (DataStoreException iee) {
				//System.out.println(iee);
			}
		}
		throw new InstrumentException.InstrumentExistsException();

	}

	@Override
	public Collection<Instrument> list() {
		// TODO Auto-generated method stub
		InstrumentDataStore ds = InstrumentDataStore.getInstance();
		return ds.list();
	}

	@Override
	public Instrument read(String name) throws InstrumentDoesntExistsException {
		InstrumentDataStore ds = InstrumentDataStore.getInstance();
		if(!ds.get(name).isPresent())
			throw new InstrumentDoesntExistsException();
		else
			return ds.get(name).get();
	}

}
