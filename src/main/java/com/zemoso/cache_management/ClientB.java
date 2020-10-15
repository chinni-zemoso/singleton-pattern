package com.zemoso.cache_management;

public class ClientB {
    public static void storeDataInCache(String key, String value) {
        ApplicationCache applicationCache=ApplicationCache.getInstance();
        applicationCache.storeInCache(key, value);
    }
}
