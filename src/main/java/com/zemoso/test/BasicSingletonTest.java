package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicSingletonTest {

	private static final Logger logger = LoggerFactory.getLogger(BasicSingletonTest.class);
	public static void main(String[] args)  {

		HibernateUtil  firstInstance = HibernateUtil.getInstance();
		HibernateUtil secondInstance = HibernateUtil.getInstance();
		
		logger.info(" firstInstance==secondInstance?"+( firstInstance==secondInstance));
		logger.info(" firstInstance hashCode::"+ firstInstance.hashCode());
		logger.info("secondInstance hashCode::"+secondInstance.hashCode());
	}//main
}//class
