package com.student.dao;

 
import java.util.Arrays;
 

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.student.ejb.Auditer;
 

public class StudentInterceptor {

	 
	@Inject
	private Auditer auditer;
	
	@AroundInvoke
	public Object log(InvocationContext inv) throws Exception {
		 
		StringBuilder builder = new StringBuilder();
		builder
		 .append("StudentDaoInterceptor Triggered for method ---->")
		 .append( inv.getTarget().getClass().getName())
		 .append(".")
		 .append(inv.getMethod().getName());
		Arrays.stream(inv.getParameters()).forEach(p->  builder.append(" " + p));  
		System.out.println(builder.toString());
		auditer.increment();
		return inv.proceed();
	}

}
