package com.zemoso.cache_management;

import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class ApplicationCache {

    private static ApplicationCache instance;
    private static boolean isInstantiated = false;
    private static final Map<String, String> inMemoryCache = new HashMap<String, String>();

    private ApplicationCache() {
        if (!isInstantiated) {
            isInstantiated = true;
        } else {
            throw new IllegalArgumentException("Reflection API based object is not allowed");
        }
    }

    public static  ApplicationCache getInstance() {
        if (instance == null) {
            synchronized (ApplicationCache.class) {
                //Logic to connect DB
                if (instance == null)
                    instance = new ApplicationCache();
                return instance;
            }
        }
        return instance;
    }//method

    public String storeInCache(String key, String value) {
        return inMemoryCache.put(key, value);
    }

    public Map<String, String> getStoredCache() {
        return inMemoryCache;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("This Singleton class,So we prevented Cloning");
    }

    private void readObject(ObjectInputStream ois) {
        throw new IllegalArgumentException("DeSerialization is not supported");
    }
}
