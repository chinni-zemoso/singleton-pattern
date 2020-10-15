package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class ReflectAPISingletonTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectAPISingletonTest.class);

    public static void main(String[] args) {
        HibernateUtil pu = null, pu1 = null;
        Constructor cons[] = null;
        //create Object
        pu = HibernateUtil.getInstance();
        logger.info("pu hashCode::" + pu.hashCode());
        try {
            //Create Another object for Singleton class through Reflection API
            //Load java class
            Class clazz = Class.forName("com.zemoso.singleton.HibernateUtil");
            //get All constructors of the class
            cons = clazz.getDeclaredConstructors();
            // Accesss private constructor
            cons[0].setAccessible(true);
            //instantiate class using The accessed consturctor
            pu1 = (HibernateUtil) cons[0].newInstance(null);
            logger.info("pu==pu1" + (pu == pu1));
            logger.info("pu hashCode::" + pu.hashCode());
            logger.info("pu1 hashCode::" + pu1.hashCode());
            logger.info("Reflect API code is executed");

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//method
}//class
