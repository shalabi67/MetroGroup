package com.metrogroup.shalabi.url;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mohammad on 9/25/2016.
 */
public class URLTests {
    @Test
    public void completePathTests() {
        for(int i=0; i<completePath.length; i++) {
            URL url = URL.create(completePath[i]);
            Assert.assertTrue(completePath[i], url.equals(completePathExpectedResult[i]));
        }
    }

    private String[] completePath = {
            "http://domain/path",
            "ftp://domain.path/path",
            "ftp://domain.path://path"
    };
    private URL[] completePathExpectedResult = {
        new URL("http", "domain", "path"),
            new URL("ftp", "domain.path", "path"),
            new URL("ftp", "domain.path:", "/path")
            //new URL("", "", ""),
    };


}
