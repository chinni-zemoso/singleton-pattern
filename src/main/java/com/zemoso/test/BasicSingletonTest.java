package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicSingletonTest {

	private static final Logger logger = LoggerFactory.getLogger(BasicSingletonTest.class);
	public static void main(String[] args)throws Exception {
		HibernateUtil pu1=null,pu2=null;
		
	   // Class.forName("com.zemoso.singleton.PrinterUtil");
		
		pu1= HibernateUtil.getInstance();
		pu2= HibernateUtil.getInstance();
		
		logger.info("pu1==pu2?"+(pu1==pu2));
		logger.info("pu1 hashCode::"+pu1.hashCode());
		logger.info("pu2 hashCode::"+pu2.hashCode());
	}//main
}//class
