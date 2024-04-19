package com.learn.rabbbit.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitmqConfiguration {

	@Value("${rabbit.mq.queue}")
	private String queue;

	@Value("${rabbit.mq.exchange}")
	private String exchange;

	@Value("${rabbit.mq.routingkey}")
	private String routingKey;

	@Bean
	Queue queue() {
		return new Queue(queue);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(exchange);

	}
}
