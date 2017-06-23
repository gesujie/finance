package com.jibinfo.finance.service.impl.demo;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.jibinfo.finance.service.demo.ProducerService;
import com.jibinfo.framework.activemq.ActivemqSendMessage;


@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

	@Resource
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage(String queueName,final ActivemqSendMessage sendMessage) {
		//设置消息消息目的地
		ActiveMQQueue destination = new ActiveMQQueue(queueName);
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				return arg0.createTextMessage(sendMessage.toJson());
			}
		});
	}

	@Override
	public void sendMessage(final ActivemqSendMessage sendMessage) {
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				return arg0.createTextMessage(sendMessage.toJson());
			}
		});
		
	}
}
