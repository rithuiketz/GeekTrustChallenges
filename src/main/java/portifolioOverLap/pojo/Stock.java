package portifolioOverLap.pojo;

import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Stock implements Instrument {

	public String stockName;

	public Collection<MutualFund> getAllMutualFundsInvested = new HashSet<>();

	public String getInstrumentName() {
		// TODO Auto-generated method stub
		return this.stockName;
	}
	
	

	public Stock(String stockName) {
		super();
		this.stockName = stockName;
	}



	public Collection<MutualFund> getAllMfsInvested() {
		return getAllMutualFundsInvested;
	}

	@Override
	public int hashCode() 
	{
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(this.stockName).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Stock))
			return false;
		Stock stk = (Stock) obj;
		return stk.hashCode()==this.hashCode();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Stock : "+this.stockName+"]";
	}

}
