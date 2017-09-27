package com.gelvt.learning;


import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Client
 *
 * @author: Elvin Zeng
 * @date: 17-8-24.
 */
public class App {
    public static void main(String[] args) {
        //  强引用，strong reference
        Foo foo = new Foo();

        //  软引用， soft reference
        List<SoftReference<Foo>> softReferenceList = new ArrayList<SoftReference<Foo>>();
        for (int i = 0; i < 99999; i++) {
            softReferenceList.add(new SoftReference<Foo>(new Foo()));
        }
        System.out.println(softReferenceList.size());

        //  弱引用， weak reference

        //  虚引用， phantom reference

    }
}
