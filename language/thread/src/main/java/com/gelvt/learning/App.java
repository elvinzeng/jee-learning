package com.gelvt.learning;


import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Client
 *
 * @author: Elvin Zeng
 * @date: 17-10-06.
 */
public class App {

    public static void log(String message){
        System.out.println(System.currentTimeMillis()
                + " [" + Thread.currentThread().getName()
                + "] " + message);
    }

    public static void interruptedByException(){
        Thread.currentThread().setName("线程A");
        log("开始执行");

        Thread anotherThread = new Thread(() -> {
            log("开始执行");
            try {
                log("开始休眠");
                Thread.sleep(5000);
                log("结束休眠");
            } catch (InterruptedException e) {
                log("被中断啦！");
            }
            log("退出");
        });
        anotherThread.setName("线程B");
        anotherThread.start();

        //  做一些耗时的操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        anotherThread.interrupt();

        log("退出");
    }

    public static void interruptedByCheckState(){
        Thread.currentThread().setName("线程A");
        log("开始执行");

        Thread anotherThread = new Thread(() -> {
            log("开始执行");

            StringBuilder sb = new StringBuilder();
            sb.append(UUID.randomUUID().toString());
            for (int i = 0; i < 99999; i++) {
                /*if (Thread.currentThread().isInterrupted()){
                    break;
                }*/
                sb.replace(0, 1, UUID.randomUUID().toString());
            }
            
            log("退出");
        });
        anotherThread.setName("线程B");
        anotherThread.start();

        //  做一些耗时的操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        anotherThread.interrupt();

        log("退出");
    }

    public static void main(String[] args) {

        //interruptedByException();

        interruptedByCheckState();

    }
}
