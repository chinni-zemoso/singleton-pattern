package com.zemoso.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThreadSingletonTest {
	private static final Logger logger = LoggerFactory.getLogger(MultiThreadSingletonTest.class);

	public static void main(String[] args) {
		TicketPrintingServletThread req1=null,req2=null;
		
		req1=new TicketPrintingServletThread();
		req2=new TicketPrintingServletThread();
		
		//create Threads
		Thread t1=new Thread(req1);
		Thread t2=new Thread(req2);
		t1.start();
		t2.start();
	}//main
}//class
