package com.gelvt.learning;


/**
 * Client
 *
 * @author: Elvin Zeng
 * @date: 17-8-17.
 */
public class App {
    public static void main(String[] args) throws
            InstantiationException, IllegalAccessException {
        GenericTypeErasureDemo<String> genericTypeErasureDemo = new GenericTypeErasureDemo<>();
        genericTypeErasureDemo.foo("hi");
    }
}
