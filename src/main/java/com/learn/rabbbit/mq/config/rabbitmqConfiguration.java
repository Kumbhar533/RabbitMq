package com.learn.rabbbit.mq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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

	@Value("${rabbit.mq.json.queue}")
	private String jsonQueue;

	@Value("${rabbit.mq.json.routingkey}")
	private String jsonRoutingKey;

	@Bean
	public Queue queue() {
		return new Queue(queue);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);

	}

	// for json binding

	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue);
	}

	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue()).to(exchange()).with(jsonRoutingKey);

	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;

	}

}
