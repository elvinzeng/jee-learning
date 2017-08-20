package com.gelvt.learning.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author: Elvin Zeng
 * @date: 17-8-20.
 */
public class Demo {
    public static void main(String[] args) {
        Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
        Producer producer = new Producer(exchanger);
        Consumer consumer = new Consumer(exchanger);
        consumer.start();
        producer.start();
    }
}
