package com.learn.rabbbit.mq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);

	@RabbitListener(queues = { "${rabbit.mq.queue}" })

	public void consumer(String message) {

		LOGGER.info(String.format("Recevied message -> %s", message));

	}

}
