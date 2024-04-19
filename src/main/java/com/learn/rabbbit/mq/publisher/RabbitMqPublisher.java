package com.learn.rabbbit.mq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqPublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqPublisher.class);

	@Value("${rabbit.mq.exchange}")
	private String exchange;

	@Value("${rabbit.mq.routingkey}")
	private String routingKey;

	private RabbitTemplate template;

	public RabbitMqPublisher(RabbitTemplate template) {
		super();
		this.template = template;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("message :-> %s", message));

		template.convertAndSend(exchange, routingKey, message);
	}

}
