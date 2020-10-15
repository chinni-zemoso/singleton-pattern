package com.zemoso.test;

import com.zemoso.singleton.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketPrintingServletThread implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(DeSerializationSingletonTest.class);


    public void run() {
        logger.info("Current Thread name::" + Thread.currentThread().getName());
        HibernateUtil firstInstance = HibernateUtil.getInstance();
        try {
            logger.info("Thread is =>"+firstInstance);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
