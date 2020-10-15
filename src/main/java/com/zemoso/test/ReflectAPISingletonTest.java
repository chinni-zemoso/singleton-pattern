package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class ReflectAPISingletonTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectAPISingletonTest.class);

    public static void main(String[] args) {
        HibernateUtil secondInstance, firstInstance;
        Constructor[] cons;
        //create Object
        secondInstance = HibernateUtil.getInstance();
        logger.info("secondInstance hashCode::" + secondInstance.hashCode());
        try {
            //Create Another object for Singleton class through Reflection API
            //Load java class
            Class clazz = Class.forName("com.zemoso.singleton.HibernateUtil");
            //get All constructors of the class
            cons = clazz.getDeclaredConstructors();
            // Access private constructor
            cons[0].setAccessible(true);
            //instantiate class using The accessed consturctor
            firstInstance = (HibernateUtil) cons[0].newInstance(null);
            logger.info("secondInstance== firstInstance" + (secondInstance == firstInstance));
            logger.info("secondInstance hashCode::" + secondInstance.hashCode());
            logger.info(" firstInstance hashCode::" + firstInstance.hashCode());
            logger.info("Reflect API code is executed");

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//method
}//class
