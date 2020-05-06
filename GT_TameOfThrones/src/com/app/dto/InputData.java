package com.app.dto;

import com.app.utils.KINGDOM;

public class InputData {

	private KINGDOM kingDom;
	
	private String message;
	
	

	public InputData(KINGDOM kingDom, String message) {
		super();
		this.kingDom = kingDom;
		this.message = message;
	}

	public KINGDOM getKingDom() {
		return kingDom;
	}

	public void setKingDom(KINGDOM kingDom) {
		this.kingDom = kingDom;
	}

	public String getMessage() {
		return message !=null ? message.toLowerCase() : null;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
