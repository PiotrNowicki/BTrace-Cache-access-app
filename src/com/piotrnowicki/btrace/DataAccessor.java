package com.piotrnowicki.btrace;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for accessing the data stored in 
 * the cache.
 * 
 * @author PiotrNowicki
 * 
 */
public class DataAccessor {
    private Logger log = 
                    Logger.getLogger(DataAccessor.class.getName());

    /**
     * The cache for our {@link Data}.
     */
    private Map<String, WeakReference<Data>> cache = 
                        new HashMap<String, WeakReference<Data>>();

    /**
     * Accesses the {@link Data} stored in cache under given
     * <code>key</code>. If the data can't be found in the cache, it
     * <strong>creates</strong> a new instance of it.
     * 
     * @param key
     *            for the data we want to fetch.
     * 
     * @return retrieved and cached data.
     */
    public Data getData(String key) {
        log.log(Level.INFO, "Fetching data by key: {0}", key);

        Data result;

        WeakReference<Data> entry = cache.get(key);

        /*
         * It's a weak reference, so we need to check if it doesn't
         * store a null value.
         */
        if (entry != null && entry.get() != null) {
            result = entry.get();
        } else {
            // The content is not important for us for this example.
            result = new Data("Randomized content = " + Math.random());
            
            cache.put(key, new WeakReference<Data>(result));
        }

        return result;
    }
}
