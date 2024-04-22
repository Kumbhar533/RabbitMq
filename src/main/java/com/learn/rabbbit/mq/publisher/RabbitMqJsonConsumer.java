package com.learn.rabbbit.mq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.learn.rabbbit.mq.dto.userDto;

@Service
public class RabbitMqJsonConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonConsumer.class);

	@RabbitListener(queues = { "${rabbit.mq.json.queue}" })
	public void jsonConsume(userDto userDto) {

		LOGGER.info(String.format("recevied json message -> %s", userDto));

	}

}
