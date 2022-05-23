package com.itechart.websocket_task2.controller;

import com.itechart.websocket_task2.model.Message;
import com.itechart.websocket_task2.service.MessageThreadSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageSenderController {
	private final MessageThreadSender messageThreadSender;

	@Autowired
	public MessageSenderController(MessageThreadSender messageThreadSender) {
		this.messageThreadSender = messageThreadSender;
	}

	@MessageMapping("/welcome")
	@SendTo("/message/answer")
	public void getMessages() {
		for (int i = 0; i < 10; i++) {
			messageThreadSender.sendMessageInThread(new Message("Thread: " + i));
		}
	}
}
