package edu.eci.arep.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Cache {

    Map<String, String> cache;


    public Cache(){
        this.cache = new HashMap<>();
    }

    /**
     * Put in cache the info of the Alpha API
     * @param symbol of the company
     * @param date options of date (intraday, daily, weekly and monthly)
     * @param apiMethod method of the api that it´ll used
     */
    void putInCache(String symbol, String date, String apiMethod) {
        this.cache.put(symbol + date, apiMethod);
    }

    /**
     * Put in cache the info of the Polygon API
     * @param symbol
     * @param apiMethod
     */
    void putInCache(String symbol, String apiMethod){
        this.cache.put(symbol,apiMethod);
    }

    /**
     * Get from cache given a key symbol
     * @param symbol of the company
     * @return
     */
    String getFromCache(String symbol){
        return this.cache.get(symbol);
    }

    /**
     * checks if the given key is in cache
     * @param key that you´ll check
     * @return
     */
    boolean isInCache(String key){
        return this.cache.containsKey(key);
    }
}
