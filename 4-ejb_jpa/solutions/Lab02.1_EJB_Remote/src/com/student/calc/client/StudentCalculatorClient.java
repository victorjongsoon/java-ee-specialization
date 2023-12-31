package com.student.calc.client;

 
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 

import com.student.calc.StudentCalculator;

public class StudentCalculatorClient {

	public static void main(String[] args) throws NamingException {
		 System.out.println("Start EJB3 Client");
		 
         Properties props = new Properties();           
         props.put("java.naming.factory.initial", "org.apache.openejb.client.LocalInitialContextFactory");
         Context ctx = new InitialContext(props);
         //TODO JNDI lookup od the EJB StudentCalculator name is name of the Bean is "myCalculator" suffixed with "Remote" ; 
	 	 StudentCalculator studentCalculator = (StudentCalculator) ctx.lookup("myCalculatorRemote"); 
         //TODO use handle on proxy to make the remote call to EJB to add numbers  
	 	 //TODO use handle on proxy to make the remote call to EJB to subtract numbers 
         int result = studentCalculator.add(4,5);
	     System.out.println("4+5=" + result);
	     result = studentCalculator.subtract(4,5);
	     System.out.println("4-5=" + result);
	     
	     System.out.println("END EJB3 Client"); 

	}

}
