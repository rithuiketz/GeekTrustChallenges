package com.app.utils;

public enum KINGDOM 
{
	AIR("AIR","Owl"), 
	LAND("LAND","Panda"), 
	WATER("WATER","Octopus"), 
	ICE("ICE","Mammoth"), 
	FIRE("FIRE","Dragon"), 
	SPACE("SPACE","Gorilla");

	private String kingDom;
	
	private String emblem;

	KINGDOM(String kingDom,String emblem) {
		this.kingDom=kingDom;
		this.emblem = emblem;
	}

	public String getEmblem() {
		return this.emblem.toLowerCase();
	}
	
	public String getKingDom()
	{
		return this.kingDom;
	}

	public String getEmblemLower()
	{
		return this.emblem.toLowerCase();
	}
}
