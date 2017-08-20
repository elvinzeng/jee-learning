package com.gelvt.learning.exchanger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Exchanger;

/**
 * @author: Elvin Zeng
 * @date: 17-8-20.
 */
public class Consumer extends Thread{
    private Exchanger<List<String>> exchanger;

    public Consumer(Exchanger<List<String>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println("消费者开始运行了..");
        for (int i = 0; i < 3; i++) {
            List<String> timeList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                timeList.add(new Date().toString());
            }
            List<String> returnedList = null;
            try {
                returnedList = exchanger.exchange(timeList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 3; j++) {
                System.out.println("生产者交给消费者的数据:" + returnedList.get(j));
            }
        }
        System.out.println("消费者退出");
    }
}
