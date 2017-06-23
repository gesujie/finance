package com.jibinfo.finance.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerDemoMessageListener implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		 //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) arg0;  
        System.out.println("接收到的消息：" + textMsg.toString());  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
		
	}

}
