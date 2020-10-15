package com.zemoso.cache_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ClientTest.class);

    public static void main(String[] args) {
        ApplicationCache applicationCache = ApplicationCache.getInstance();
        logger.info("Cached Application Data =>" + applicationCache.getStoredCache());
        //client A
        ClientA.storeDataInCache("1", "Data Added by Client A");
        ClientA.storeDataInCache("2", "Data Added by Client A");
        ClientA.storeDataInCache("3", "Data Added by Client A");

        logger.info("Cached Application Data =>" + applicationCache.getStoredCache());

        //client B
        ClientB.storeDataInCache("4", "Data Added by Client B");
        ClientB.storeDataInCache("5", "Data Added by Client B");
        ClientB.storeDataInCache("6", "Data Added by Client B");

        logger.info("Cached Application Data =>" + applicationCache.getStoredCache());
    }
}
