package com.gelvt.learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Elvin Zeng
 * @date: 17-8-19.
 */
public class NopTask implements Runnable{
    private static AtomicInteger taskCount = new AtomicInteger(1);
    private int taskId;
    private final int timeout;

    public NopTask(int timeout) {
        this.timeout = timeout;
        taskId = taskCount.getAndAdd(1);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("开始执行任务[" + taskId + "]");
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("任务[" + taskId + "]执行完毕，一共耗时["
                + (endTime - startTime) + "]毫秒");
    }

    public static void main(String[] args){
        System.out.println("主线程启动");
        ExecutorService excutor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            excutor.execute(new NopTask(2));
        }
        excutor.shutdown();
        System.out.println("主线程退出");
    }
}
