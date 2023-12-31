package com.student.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.student.core.Student;

@Stateless(name = "studentDao")
@Local(StudentDao.class)
@Remote(StudentDao.class)
@Interceptors(value = StudentInterceptor.class)
public class StudentDaoBean implements StudentDao {
	 
	/*
	 * private Map<Long, Student> students; { students = new HashMap<>();
	 * students.put(1L, new Student(1, "Eric", "Colbert", "English Literature",
	 * 145.00)); students.put(2L, new Student(2, "Mary", "Contrary", "Physiscs",
	 * 155.00)); students.put(3L, new Student(3, "Jason", "Stewart",
	 * "English Literature", 145.00)); students.put(4L, new Student(4, "Ester",
	 * "Freeman", "English Literature", 145.00)); students.put(5L, new Student(5,
	 * "Ann", "Mouvier", "French", 125.00));
	 * 
	 * }
	 */
	// TODO
	@PersistenceContext(unitName = "student")
	private EntityManager em;
	

	@Override
	public Student getOne(long id) {
		return em.find(Student.class, id);
		 

	}

	@Override
	public Collection<Student> getAll() {
		return em.createQuery("SELECT s FROM Student s").getResultList();
		// return students.values();
	}

	@Override
	public void add(Student student) {
		/*
		 * long maxId = students.keySet().stream().count(); student.setFees(100.00);
		 * student.setId(++maxId); students.put(maxId, student);
		 */
		student.setFees(100.00);
		em.persist(student); 
	}



}
