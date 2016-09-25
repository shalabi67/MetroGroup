package com.metrogroup.shalabi.url;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mohammad on 9/25/2016.
 */
public class URLTests {
    @Test
    public void completePathTests() {
        String[] urls = completePath;
        URL[] expectedURls = completePathExpectedResult;
        runTest(urls, expectedURls);
    }

    @Test
    public void missingPathPartTests() {
        String[] urls = missingPathPart;
        URL[] expectedURls = missingPathPartExpectedResult;
        runTest(urls, expectedURls);
    }

    private void runTest(String[] urls, URL[] expectedURls) {
        for(int i=0; i<urls.length; i++) {
            URL url = URL.create(urls[i]);
            Assert.assertTrue(urls[i], url.equals(expectedURls[i]));
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

    private String[] missingPathPart = {
            "domain",
            "",
            "http://",
            "http://domain",
            "domain/path",

    };
    private URL[] missingPathPartExpectedResult = {
            new URL("", "domain", ""),
            new URL("", "", ""),
            new URL("http", "", ""),
            new URL("http", "domain", ""),
            new URL("", "domain", "path")
    };

    private String[] invalidURl = {
        "/path",
        "",
        null
    };

}
