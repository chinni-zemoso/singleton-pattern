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
		HibernateUtil otherInstance, firstInstance;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		//get Object
		otherInstance= HibernateUtil.getInstance();
		//Perform serialization on the object
		try{
		 oos=new ObjectOutputStream(new FileOutputStream("/home/projects/singleton.ser"));
		 oos.writeObject(otherInstance);
		 oos.flush();
		 oos.close();
		 logger.info("Serialization is done");
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//perform Deserialization
		try{
			ois=new ObjectInputStream(new FileInputStream("/home/projects/singleton.ser"));
		     firstInstance=(HibernateUtil) ois.readObject();
		    logger.info("DeSerialization");
		    logger.info("otherInstance== firstInstance?"+(otherInstance== firstInstance));
		    logger.info("otherInstance hashCode::"+otherInstance.hashCode());
		    logger.info(" firstInstance hashCode::"+ firstInstance.hashCode());
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
