package com.itechart.websocket_task2.service;

import com.itechart.websocket_task2.model.Message;

public interface MessageThreadSender {

	void sendMessageInThread(Message message);

}
