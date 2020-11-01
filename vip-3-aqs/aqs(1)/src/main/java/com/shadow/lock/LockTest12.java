package com.shadow.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class LockTest12 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();//获取锁
                log.debug("获取锁----");


            } catch (Exception e) {

                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1");
        t1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();//获取锁
                log.debug("获取锁----");
                TimeUnit.SECONDS.sleep(10);
                log.debug("t2 5s 之后继续执行");
            } catch (InterruptedException e) {
                System.out.println("sleep interrupt");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t2");
        t2.start();

        TimeUnit.SECONDS.sleep(1);

        t2.interrupt();






    }
}
