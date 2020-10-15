package com.zemoso.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeSerializationSingletonTest {
	private static final Logger logger = LoggerFactory.getLogger(DeSerializationSingletonTest.class);

	public static void main(String[] args) {
		HibernateUtil pu=null,pu1=null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		//get Object
		pu= HibernateUtil.getInstance();
		//Perform Serialziation on the object
		try{
		 oos=new ObjectOutputStream(new FileOutputStream("/home/projects/singleton.ser"));
		 oos.writeObject(pu);
		 oos.flush();
		 oos.close();
		 logger.info("Serialization is done");
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//perform Deserialziation
		try{
			ois=new ObjectInputStream(new FileInputStream("/home/projects/singleton.ser"));
		    pu1=(HibernateUtil) ois.readObject();
		    logger.info("DeSerialization");
		    logger.info("pu==pu1?"+(pu==pu1));
		    logger.info("pu hashCode::"+pu.hashCode());
		    logger.info("pu1 hashCode::"+pu1.hashCode());
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
