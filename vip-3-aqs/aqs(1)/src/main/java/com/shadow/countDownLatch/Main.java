package com.shadow.countDownLatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 钢牌讲师--子路
 **/


@Slf4j(topic = "e")
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
        //System.out.println(executor.getActiveCount()+"===================");
        int taskNum = 13;
        for (int i = 0; i < taskNum; i++) {
            final int finalI = i;
            if (i == 4) {

                System.out.println(executor.getActiveCount()+"===================");
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("提交任务：" + (i + 1));
            executor.submit(new Runnable() {
                public void run() {
                    Integer taskNum = finalI + 1;
                    System.out.println(executor.getActiveCount()+"===================");
                    System.out.println("task: " + taskNum + ", " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
                }
            });
        }
    }
}






