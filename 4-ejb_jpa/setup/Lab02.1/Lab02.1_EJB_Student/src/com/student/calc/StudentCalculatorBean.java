package com.student.calc;

 
import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
//TODO Add annotations and give the bean the name myCalculator
 
//TODO Add annotation for Remote and state Interface that us the remote from which the proxies are generated
 
public class StudentCalculatorBean implements StudentCalculator {
	private Logger logger = Logger.getLogger("StudentCalculatorBean");

	public int add(int i1, int i2) {
		logger.info("In add method " + i1 + ", " + i2);
		return i1+i2;
	}

	public int subtract(int i1, int i2) {
		logger.info("In subtract method " + i1 + ", " + i2);
		return i1-i2;
	}

}
