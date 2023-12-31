package com.student.dao;
 
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.student.core.Student;
 
 
@Stateless(name="studentDao")
@Local(StudentDao.class)
@Remote(StudentDao.class)
//TODO
@Interceptors(value=StudentInterceptor.class)
public class StudentDaoBean implements StudentDao {
	 
	@Resource
	private SessionContext sessionContext;
 
	 
	private Map<Long, Student> students;
	{
		students = new HashMap<>();
		students.put(1L, new Student(1,"Eric", "Colbert", "English Literature", 145.00));
		students.put(2L, new Student(2,"Mary", "Contrary", "Physiscs", 155.00));
		students.put(3L, new Student(3,"Jason", "Stewart", "English Literature", 145.00));
		students.put(4L, new Student(4,"Ester","Freeman", "English Literature", 145.00));
		students.put(5L, new Student(5,"Ann","Mouvier", "French", 125.00));
		
		
	}
	@Override
	public Student getOne(long id) {
		return  students.get(id);
	}
	@Override
	public Collection<Student> getAll() {
		return students.values();
	}
	
}
