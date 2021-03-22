package com.ptit.storeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;

@RestController
@RequestMapping("/")
public class StoreController {
	@Value("spring.application.name")
	String applicationName;

	@Autowired
	private Environment env;

	@Autowired
	private Topic topic;

	@Autowired
	private JmsTemplate jmsTemplate;

	@PatchMapping("/product/{produc-id}")
	public String updateProduct(@PathVariable("produc-id") String productId){
		String message = "Updated product " + productId ;
		jmsTemplate.convertAndSend(topic, String.join(" ",applicationName,env.getProperty("local.server.port")));
		return message;
	}

}
