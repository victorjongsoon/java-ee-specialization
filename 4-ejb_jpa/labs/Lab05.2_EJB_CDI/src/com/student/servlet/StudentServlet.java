package com.student.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.core.Student;
import com.student.dao.StudentDao;
import com.student.ejb.AppMessageProducer;
 
/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	@EJB  
	private StudentDao studentDao;
	
	@Inject
	private AppMessageProducer appMessageProducer;
	
    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		if(Objects.isNull(strId)){
			Collection<Student> students = studentDao.getAll();
			request.setAttribute("students", students);
		} else {
		  Student student = studentDao.getOne(Long.parseLong(strId));
		   request.setAttribute("student", student);
		   appMessageProducer.sendMessage(student);
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	/*
	private void sendMessage(Student student) {
		Connection connection = null;
		Object session = null;
		try {
			connection = connectionFactory.createConnection();
			System.out.println("ConnectionFactory instance is created");
			connection.start();
			System.out.println("Session instance is started");
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// Creates a MessageProducer from Session to Queue
			MessageProducer producer = ((Session) session).createProducer(fooQueue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage message = ((Session) session).createTextMessage("Request for " + student.getFirstName() + " " + student.getSurname());
			System.out.println("Message created");
			producer.send(message);
			System.out.println("Messeage sent");
	} catch (Exception e) {
		e.printStackTrace();
		try {
			connection.close();
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
	}
   
	}
	*/
}
