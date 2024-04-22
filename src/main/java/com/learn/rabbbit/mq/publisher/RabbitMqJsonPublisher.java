package com.learn.rabbbit.mq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learn.rabbbit.mq.dto.userDto;

@Service
public class RabbitMqJsonPublisher {

	@Value("${rabbit.mq.json.routingkey}")
	private String jsonRoutingKey;

	@Value("${rabbit.mq.exchange}")
	private String exchange;

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonPublisher.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendJsonMessage(userDto Userdto) {

		LOGGER.info(String.format("message published - > %s", Userdto.toString()));

		rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, Userdto);

	}

}
