package portifolioOverLap.pojo;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Portifolio 
{

	private Collection<MutualFund> mutualFunds = new LinkedHashSet<>();

	public void addAddMfToPortifolio(MutualFund mf)
	{
		mutualFunds.add(mf);
	}

	public void setMutualFunds(Collection<MutualFund> mutualFunds) {
		this.mutualFunds = mutualFunds;
	}

	public Collection<MutualFund> getMutualFunds() {
		// TODO Auto-generated method stub
		return this.mutualFunds;
	}
	
	
	

}
