package com.app.service;


import com.app.componet.Ruler;
import com.app.service.messaging.BasicMessageImpl;
import com.app.service.messaging.Message;
import com.app.service.messaging.MessageService;

public class ApplicationServiceImpl implements ApplicationService {
	
	private MessageService msgSvc;

	public ApplicationServiceImpl(MessageService msgSvc) {
		super();
		this.msgSvc = msgSvc;
	}

	@Override
	public Ruler chekForKingDomDefeated(Ruler rcvr,Ruler sender,int chipperLength,String msgStr) 
	{
		Message msg = new BasicMessageImpl(sender,rcvr,msgStr,chipperLength);
		msgSvc.sendMessage(msg);
		return msgSvc.isSenderOwn() == true ? rcvr :  null;
	}
	

}
