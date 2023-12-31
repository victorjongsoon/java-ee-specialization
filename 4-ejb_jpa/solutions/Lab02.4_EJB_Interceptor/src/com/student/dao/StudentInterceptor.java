package com.student.dao;

 
import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

 

public class StudentInterceptor {

	 
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
		
		return inv.proceed();
	}

}
