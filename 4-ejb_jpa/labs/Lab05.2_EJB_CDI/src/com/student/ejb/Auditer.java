package com.student.ejb;

import javax.ejb.Singleton;
import javax.ejb.Startup;



@Singleton
@Startup
public class Auditer {

	private int requestCounter;

	public void increment() {
		this.requestCounter++;
		System.out.println("Current value of increment: " + requestCounter);
	}

	 
}
