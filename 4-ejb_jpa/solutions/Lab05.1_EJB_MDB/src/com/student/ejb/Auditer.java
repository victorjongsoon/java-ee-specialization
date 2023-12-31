package com.student.ejb;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.sun.istack.internal.logging.Logger;

@Singleton
@Startup
public class Auditer {
	private Logger logger = Logger.getLogger(this.getClass());
	private int requestCounter;

	public void increment() {
		this.requestCounter++;
		logger.info("Total number of requests so far are " + requestCounter);
	}

	 
}
