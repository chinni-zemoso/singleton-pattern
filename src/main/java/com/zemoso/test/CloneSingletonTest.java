package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloneSingletonTest {

    private static final Logger logger = LoggerFactory.getLogger(CloneSingletonTest.class);

    public static void main(String[] args) {
        HibernateUtil firstInstance, secondInstance;

        try {
            firstInstance = HibernateUtil.getInstance();
            //perform cloning
            secondInstance = (HibernateUtil) firstInstance.clone();
            logger.info(" firstInstance==secondInstance?" + (firstInstance == secondInstance));
            logger.info(" firstInstance hashCode::" + firstInstance.hashCode());
            logger.info("secondInstance hashCode::" + secondInstance.hashCode());
        }//try
        catch (CloneNotSupportedException cne) {
            cne.printStackTrace();
        }

    }//main
}//class
