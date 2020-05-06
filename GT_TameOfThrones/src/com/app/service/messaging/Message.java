package com.app.service.messaging;

import com.app.componet.Ruler;

public interface Message 
{
	
	public Ruler getSender();
	
	public String getMsg();
	
	public Ruler getReciever();
	
	public int getChipperKeyLength();

}
