package com.api.producer.resource;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.producer.rabbitconfiguration.CustomMessage;
import com.api.producer.rabbitconfiguration.MQConfig;

@RestController
@RequestMapping(value="/api")
public class MessagePublisher {

	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/publishmessage")
	public String publishRequestKeyMessage(@RequestBody CustomMessage message) {
		
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MQConfig.KEYREQUESTEXCHANGE,MQConfig.KEYREQUESTBINDING, message);
		return "Mensagem Publicada";
		
	}
	
}
