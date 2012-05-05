package com.piotrnowicki.btrace;

/**
 * Exemplary data that will be stored in the cache. The existence of 
 * the Data makes sense only with some content; default constructor 
 * is not provided. Use {@link Data#Data(String)} instead.
 * 
 * @author PiotrNowicki
 * 
 */
public class Data {

    private String content;

    public Data(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
