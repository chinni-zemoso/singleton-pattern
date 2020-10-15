package com.zemoso.singleton;

import com.zemoso.util.CommonsUtils;

import java.io.ObjectInputStream;

public class HibernateUtil extends CommonsUtils {

    private static HibernateUtil instance;
    private static boolean isInstantiated = false;

    private HibernateUtil() {
        if (!isInstantiated) {
            isInstantiated = true;
        } else {
            throw new IllegalArgumentException("Reflection API based object is not allowed");
        }
    }

    public static HibernateUtil getInstance() {
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
