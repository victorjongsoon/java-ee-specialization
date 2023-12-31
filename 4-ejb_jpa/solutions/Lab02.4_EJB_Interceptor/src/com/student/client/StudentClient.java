package com.student.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.student.core.Student;
import com.student.dao.StudentDao;
import com.student.ejb.StudentService;

 

public class StudentClient {

	public static void main(String[] args) throws NamingException {
         System.out.println("Start EJB3 Client");
		 
         Properties props = new Properties();           
         props.put("java.naming.factory.initial", "org.apache.openejb.client.LocalInitialContextFactory");
        // props.setProperty("openejb.deployments.classpath.include", ".*resource-injection.*");
         Context ctx = new InitialContext(props);
         //TODO JNDI lookup for the EJB StudentService the name is name of Bean "studentService" suffixed with "Remote" ; 
	 	 StudentService studentService = (StudentService) ctx.lookup("studentServiceRemote"); 
         //TODO use handle on proxy to make a remote call to the EJB to get student with an id of 1L  
	 	 Student student = studentService.getStudent(1L);
	 	 System.out.println(student);
	 	 //TODO getStudentDao Service that now has a Remote interface
	 	 //before this code would fail with
	 	 //Exception in thread "main" javax.naming.NameNotFoundException: Name "studentDaoRemote" not found.
	 	 StudentDao studentDao = (StudentDao) ctx.lookup("studentDaoRemote"); 
	 	 student = studentDao.getOne(5L);
	 	 System.out.println(student);
	 	 
	 	 System.out.println("END EJB3 Client"); 
	}

}
