package com.zemoso.singleton;

import com.zemoso.util.CommonsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;

public class HibernateUtil extends CommonsUtils {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    private static HibernateUtil instance;
    private static boolean isInstantiated = false;

    private HibernateUtil() {
        if (isInstantiated == false) {
            isInstantiated = true;
        } else {
            throw new IllegalArgumentException("Reflection API based object is not allowed");
        }
    }

    public static final HibernateUtil getInstance() {
        if (instance == null) {
            synchronized (HibernateUtil.class) {
                //Logic to connect DB
                if (instance == null)
                    instance = new HibernateUtil();
                return instance;
            }
        }
        return instance;
    }//method

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("This Singleton class,So we prevented Cloning");
    }

    private void readObject(ObjectInputStream ois) {
        throw new IllegalArgumentException("DeSerialization is not supported");
    }
}
