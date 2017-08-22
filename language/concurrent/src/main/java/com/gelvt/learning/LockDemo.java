package com.gelvt.learning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Elvin Zeng
 * @date: 17-8-22.
 */
public class LockDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int state = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testReentranLock(state);
                }
            }).start();
        }
    }

    public static void testReentranLock(int state){
        try{
            lock.lock();
            System.out.println("编号为[" + state + "]的线程开始运行..");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("编号为[" + state + "]的线程退出");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
