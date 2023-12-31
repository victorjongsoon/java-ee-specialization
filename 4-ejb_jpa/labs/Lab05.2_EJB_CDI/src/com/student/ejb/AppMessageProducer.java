package com.student.ejb;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.student.core.Student;
@Named
public class AppMessageProducer {
	@Resource
	private ConnectionFactory connectionFactory;

	@Resource(name = "FooQueue")
	private Queue fooQueue;
	
	public void sendMessage(Student student) {
		Connection connection = null;
		Object session = null;
		try {
			connection = connectionFactory.createConnection();
			System.out.println("ConnectionFactory instance is started");
			connection.start();
			System.out.println("Session instance is started");
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = ((Session) session).createProducer(fooQueue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage message = ((Session) session).createTextMessage("Request for " + student.getFirstName() + " " + student.getSurname());
			System.out.println("Message created");
			producer.send(message);
			System.out.println("Message sent");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}
	}

}
