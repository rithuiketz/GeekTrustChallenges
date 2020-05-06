package com.app.service;

import java.util.Collection;

import com.app.componet.Ruler;
import com.app.dto.InputData;

public interface ApplicationService 
{

	public Ruler chekForKingDomDefeated(Ruler rcvr,Ruler sender,int chipperLength,String msg);
}
