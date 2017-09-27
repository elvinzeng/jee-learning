package com.gelvt.learning;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Client
 *
 * @author: Elvin Zeng
 * @date: 17-9-27.
 */
public class App {

    public static void main(String[] args) throws NoSuchMethodException {
        String str = "hello, this is elvin.";
        String pattern = "^(hello)(?:,\\s*this)([^\\.]+)\\.$";
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        if(matcher.find()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }

        pattern = "^(hello)(?=,\\s*this)([^\\.]+)\\.$";
        matcher = Pattern.compile(pattern).matcher(str);
        if(matcher.find()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }

    }
}
