package com.jibinfo.finance.service.demo;

import com.jibinfo.framework.activemq.ActivemqSendMessage;


public interface ProducerService {
	/**
	 * 发送消息
	 * @param queueName    发送目的地名称
	 * @param sendMessage  发送内容
	 */
	void sendMessage(String queueName, ActivemqSendMessage sendMessage);
	
	/**
	 * 发送消息
	 * @param sendMessage  发送内容
	 */
	void sendMessage(ActivemqSendMessage sendMessage);
	
}
