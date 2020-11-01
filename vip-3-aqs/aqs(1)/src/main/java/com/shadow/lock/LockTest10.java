package com.shadow.lock;

import com.shadow.aqs.CustomSync;
import lombok.extern.slf4j.Slf4j;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;


@Slf4j(topic = "enjoy")
public class LockTest10 {

      static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
      static Lock r = rwl.readLock();
      static Lock w = rwl.writeLock();


    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            log.debug("read 获取 锁");
            r.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    m1(i);
                }
            }finally {
                r.unlock();
            }


        },"t1").start();


        new Thread(()->{
            log.debug("write 获取 锁");
            w.lock();
            try {
                for (int i = 0; i < 20; i++) {
                    m1(i);
                }
            }finally {
                w.unlock();
            }

        },"t2");


        new Thread(()->{
            log.debug("write 获取 锁");
            r.lock();
            try {
                for (int i = 0; i < 20; i++) {
                    m1(i);
                }
            }finally {
                r.unlock();
            }

        },"t3").start();

    }


    public static void m1(int i){
            log.debug("exe"+i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
