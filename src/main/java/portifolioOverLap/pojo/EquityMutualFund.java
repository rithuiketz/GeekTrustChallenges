package portifolioOverLap.pojo;

import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import portifolioOverLap.exceptions.InstrumentException.InstrumentAlreadyMappedException;
import portifolioOverLap.exceptions.InstrumentException.InstrumentExistsException;

/**
 * 
 * Mutual fund can be like any tipe like ELSS equity, hybrid etc, this is an
 * implementation of Equity MF
 * 
 * @author ry123809
 *
 */

public class EquityMutualFund implements MutualFund {

	private String mfName;

	private Collection<Instrument> stocks = new HashSet<Instrument>();

	public EquityMutualFund(String mfName) {
		this.mfName = mfName;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.mfName;
	}

	public Collection<Instrument> getAllInstruments() {
		return stocks;
	}

	public void addStockToFund(Instrument stock) {
		if (stock == null)
			return;
		stocks.add(stock);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(this.mfName.replaceAll(" ", "_")).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof EquityMutualFund))
			return false;
		EquityMutualFund mf = (EquityMutualFund) obj;
		return mf.hashCode() == this.hashCode();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ Mutual Fund :" + this.mfName + " ]";
	}

}
