package com.student.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import com.student.core.Student;
import com.student.dao.StudentDao;

//TODO Annotations the name fo the bean is "studentService"
 
//TODO Remote is studentService
 
public class StudentServiceBean implements StudentService {
	//TODO inject the StudentDao bean into this EJB,  
	private StudentDao studentDao;

	@Override
	public Student getStudent(Long id) {
		return studentDao.getOne(id);
	}
 
}
