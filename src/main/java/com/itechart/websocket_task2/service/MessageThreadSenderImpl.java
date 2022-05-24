package com.itechart.websocket_task2.service;

import com.itechart.websocket_task2.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableScheduling
public class MessageThreadSenderImpl implements MessageThreadSender {
	private final SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	public MessageThreadSenderImpl(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

	@Override
	public void sendMessageInThread(String destination, Message message) {
		new Thread(() -> {
			int minTime = 1000;
			int maxTime = 15000;
			Random random = new Random();
			try {
				Thread.sleep(random.nextLong(minTime, maxTime));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			simpMessagingTemplate.convertAndSend(destination , message);
		}).start();
	}
}
