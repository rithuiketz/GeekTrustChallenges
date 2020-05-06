package com.app.service.messaging;

import com.app.componet.Ruler;

public class BasicMessageImpl implements Message {
	
	private Ruler sender,reciever;
	private String msg;
	private int chipperKeyLngth;


	public BasicMessageImpl(Ruler sender, Ruler reciever, String msg,
			int chipperKeyLngth) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.msg = msg;
		this.chipperKeyLngth = chipperKeyLngth;
	}

	@Override
	public Ruler getSender() {
		// TODO Auto-generated method stub
		return this.sender;
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return this.msg;
	}

	@Override
	public Ruler getReciever() {
		// TODO Auto-generated method stub
		return this.reciever;
	}

	@Override
	public int getChipperKeyLength() {
		// TODO Auto-generated method stub
		return this.chipperKeyLngth;
	}

}
