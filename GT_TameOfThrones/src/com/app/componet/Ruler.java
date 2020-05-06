package com.app.componet;

import com.app.utils.KINGDOM;

public class Ruler {

	private KINGDOM kingdom;

	public KINGDOM getKingdom() {
		return kingdom;
	}

	public void setKingdom(KINGDOM kingdom) {
		this.kingdom = kingdom;
	}

	public Ruler(KINGDOM kingdom) {
		super();
		this.kingdom = kingdom;
	}
	
	public String getEmblem()
	{
		return this.kingdom.getEmblem();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj==null || ! (obj instanceof Ruler))
		{
			return false;
		}
		Ruler comparingObj = (Ruler)obj;
		return this.getKingdom().equals(comparingObj.getKingdom());
	}
	
	@Override
	public int hashCode() {
		return this.kingdom.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.kingdom.getKingDom();
	}
}
