package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloneSingletonTest {

	private static final Logger logger = LoggerFactory.getLogger(CloneSingletonTest.class);
	public static void main(String[] args) {
		HibernateUtil pu1=null,pu2=null;
		
		try{
			pu1= HibernateUtil.getInstance();
			//perform cloning
			pu2=(HibernateUtil)pu1.clone();
			logger.info("pu1==pu2?"+(pu1==pu2));
			logger.info("pu1 hashCode::"+pu1.hashCode());
			logger.info("pu2 hashCode::"+pu2.hashCode());
		}//try
		catch(CloneNotSupportedException cne){
		  cne.printStackTrace();	
		}

	}//main
}//class
