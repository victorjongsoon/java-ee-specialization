package com.student.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.student.core.Student;
//TODO
@Stateful  
@SessionScoped
@Local
@Named("studentDaoWaitList")
public class StudentDaoWaitListBean implements StudentDaoWaitList {
	@Resource
	private ConnectionFactory connectionFactory;

	@Resource(name = "FooQueue")
	private Queue fooQueue;

	private List<Student> provisionalStudents = new ArrayList<>();

	@Override
	public void add(Student student) {
		this.provisionalStudents.add(student);

	}

	@Override
	public Collection<Student> getAll() {
		return provisionalStudents;
	}
 
	@PostConstruct //TODO
	public void init() {
		System.out.println("WaitList PostConstruct method called");
	}

	@PreDestroy //TODO
	public void exit() {
		System.out.println("WaitList PreDestroy method called");
	}

 
	
}
