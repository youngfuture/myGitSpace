package com.lock;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class TestLock {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {



        //tn 最先拿到锁
        new Thread(()->{
            lock.lock();
                log.debug("-----");
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            lock.unlock();
        },"tn").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动十个线程 回去排队，因为tn持有了锁
        for (int i = 0; i <10 ; i++) {
            try {
                TimeUnit.NANOSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(()->{
                lock.lock();
                log.debug("-----");
               lock.unlock();
            },"t"+i).start();
        }
    }
}
