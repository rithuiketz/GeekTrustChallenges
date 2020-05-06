package com.app.service.messaging;

import com.app.service.messaging.Message;

public interface MessageService {
	
	public void sendMessage(Message msg);
	
	public boolean isSenderOwn();

}
