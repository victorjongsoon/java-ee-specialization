package com.student.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.student.core.Student;
import com.student.dao.StudentDao;

@Stateless(name = "studentService")
@Remote(StudentService.class)
public class StudentServiceBean implements StudentService {
 
	@Inject
	private StudentDao studentDao; 
	

	@Override
	public Student getStudent(Long id) {
		return studentDao.getOne(id);
	}

 
}
