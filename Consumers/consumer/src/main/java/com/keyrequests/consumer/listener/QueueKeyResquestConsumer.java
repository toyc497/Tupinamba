package com.keyrequests.consumer.listener;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.keyrequests.consumer.model.KeyObject;
import com.keyrequests.consumer.repository.KeyObjectRepository;

@Component
public class QueueKeyResquestConsumer {
	
	@Autowired
	private KeyObjectRepository keyObjectRepository;
	
	@RabbitListener(queues={"${queue.name}"})
	public List<KeyObject> receiver(@Payload String filebody) {
		
		//String msgJson = filebody;
		
		List<KeyObject> listKey = keyObjectRepository.findAll();
		
		return listKey;
		
	}
	
}
