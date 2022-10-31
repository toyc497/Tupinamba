package com.api.producer.rabbitconfiguration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class MQConfig {

	public static final String FILAKEYREQUESTS = "filaKeyRequests";
	public static final String KEYREQUESTEXCHANGE = "keyRequestExchange";
	public static final String KEYREQUESTBINDING = "keyRequestBinding";
	
	@Bean
	public Queue keyRequestQueue() {
		
		return new Queue(FILAKEYREQUESTS,false);	
		
	}
	
	@Bean
	public DirectExchange keyRequestsExchange() {
		
		return new DirectExchange(KEYREQUESTEXCHANGE);
		
	}
	
	@Bean
	public Binding keyRequestsBinding(Queue queueParam, DirectExchange dirExcParam) {
		
		return BindingBuilder
				.bind(queueParam)
				.to(dirExcParam)
				.with(KEYREQUESTBINDING);
				
		
	}
	
	@Bean
	public MessageConverter messageConverter() {
		
		return new Jackson2JsonMessageConverter();
		
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
		
	}
	
}
