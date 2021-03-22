package com.ptit.storeservice.controller.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageConsumer {
	private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	@JmsListener(destination = "test-topic")
	public void listener(String message){
		System.out.println(message);
	}
}
