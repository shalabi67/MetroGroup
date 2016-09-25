package com.metrogroup.shalabi;

import com.metrogroup.shalabi.url.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("please enter a URL. valid URLs are in the form of:\n[protocol://][domain[/[path]]]\n" +
                "where any thing between [] is optional.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();

            URL url = URL.create(input);
            System.out.println(url.toString());
        }catch (IOException e) {
            System.out.println("Invalid input.");
        }

    }
}
