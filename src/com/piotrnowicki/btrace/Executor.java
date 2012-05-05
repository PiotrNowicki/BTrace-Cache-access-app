package com.piotrnowicki.btrace;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.piotrnowicki.btrace.DataAccessor;

/**
 * Main entry point for the application. Simulates multiple random
 * accesses to the cache.
 * 
 * @author PiotrNowicki
 * 
 */
public class Executor {

    private Logger log = Logger.getLogger(Executor.class.getName());

    public static void main(String[] args) {
        new Executor().execute();
    }

    /**
     * Simulates multiple cache access requests.
     */
    void execute() {
        DataAccessor dataAccessor = new DataAccessor();

        for (int i = 0; i < 1000; i++) {
            dataAccessor.getData(generateKey());
            sleep();
        }
    }

    /**
     * Helper method for random cache key generation. The number is 
     * from the range <0, 100).
     * 
     * @return generated key
     */
    String generateKey() {
        return new Random().nextInt(100) + "";
    }

    /**
     * Helper method for random sleep time generation. The sleep time 
     * is from the range <0, 1000).
     * 
     * @return generated sleep time
     */
    long getSleepTime() {
        return new Double(Math.random() * 1000).longValue();
    }

    /**
     * Helper method for making the current Thread go to sleep for 
     * some time.
     */
    void sleep() {
        long sleepTime = getSleepTime();

        try {
            log.log(Level.INFO, "Going to sleep for {0} milliseconds",
                    sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            // no-op for exemplary purpose
        }
    }
}
