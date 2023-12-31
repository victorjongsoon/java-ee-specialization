package com.student.ejb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = { 
		@ActivationConfigProperty(
				propertyName = "destinationType", 
				propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty( 
				propertyName = "destination", 
				propertyValue = "FooQueue") 
	})
public class StudentRegistrationListener implements MessageListener {
	 
	@Resource
	private ConnectionFactory connectionFactory;

	@Resource(name = "fooQueue")
	private Queue fooQueue;
 
	@Override
	public void onMessage(Message message) {
		final TextMessage textMessage = (TextMessage) message;
		 
		try {
			String receipt = textMessage.getText();
			System.out.println("Recevied------->" + receipt);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
