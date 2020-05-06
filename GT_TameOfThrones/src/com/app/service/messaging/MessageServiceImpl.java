package com.app.service.messaging;

import com.app.utils.chipper.ChipperUtils;

public class MessageServiceImpl implements MessageService {

	private boolean isSenderOwn;

	@Override
	public void sendMessage(Message msg) 
	{	
		checkForMessageValidityToOwnTheKingDom(msg);
		
	}

	@Override
	public boolean isSenderOwn() {
		return isSenderOwn;
	}

	public void checkForMessageValidityToOwnTheKingDom(Message msg)
	{
		this.isSenderOwn=true;
		String mesg  = msg.getMsg();
		int chipperKeyLength = msg.getChipperKeyLength();
		String recieverEmblem =msg.getReciever().getKingdom().getEmblem();
		String decodedMsg = ChipperUtils.decodedString(mesg, chipperKeyLength);
		int length=decodedMsg.length();
		if(recieverEmblem.length() >  length)
		{
			this.isSenderOwn = false;
			return;
		}
		int[] rcvrEmblemCount=new int[26],decodeMsgCharCount =new int[26];
		int idx;
		for(int i=0;i<recieverEmblem.length();i++)
		{
			idx=recieverEmblem.charAt(i)-97;
			rcvrEmblemCount[idx]=rcvrEmblemCount[idx]+1;
		}
		for(int i=0;i<length;i++)
		{
			idx=decodedMsg.charAt(i)-97;
			decodeMsgCharCount[idx]=decodeMsgCharCount[idx]+1;
		}
		
		for(int i=0;i<26;i++)
		{
			if(decodeMsgCharCount[i] < rcvrEmblemCount[i])
			{
				this.isSenderOwn=false;
			}
		}		
	}
}
