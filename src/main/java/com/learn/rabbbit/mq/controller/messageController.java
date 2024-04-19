package com.learn.rabbbit.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.rabbbit.mq.publisher.RabbitMqPublisher;

@RestController
@RequestMapping("/api/v1")
public class messageController {

	@Autowired
	private RabbitMqPublisher rabbitMqPublisher;

	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {

		rabbitMqPublisher.sendMessage(message);

		return ResponseEntity.ok("message send successfully to RabbitMq....");

	}

}
