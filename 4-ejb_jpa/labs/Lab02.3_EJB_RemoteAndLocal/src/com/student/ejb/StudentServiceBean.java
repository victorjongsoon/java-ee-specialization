package com.student.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.student.core.Student;
import com.student.dao.StudentDao;

//TODO Annotations the name fo the bean is "studentService"
@Stateless(name="studentService")
//TODO Remote is studentService
@Remote(StudentService.class)
public class StudentServiceBean implements StudentService {
	//TODO inject the StudentDao bean into this EJB, You need a jakarta Qualifier of @Any for any implementation of theis interface (we have onyl 1 so no conflicts
	@Inject  
	private StudentDao studentDao;

	@Override
	public Student getStudent(Long id) {
		return studentDao.getOne(id);
	}
 
}
