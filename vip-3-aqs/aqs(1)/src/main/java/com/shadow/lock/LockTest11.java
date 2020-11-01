package com.shadow.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;




@Slf4j(topic = "enjoy")
public class LockTest11 {

      static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
      static Lock r = rwl.readLock();
      static Lock w = rwl.writeLock();


    public static void main(String[] args) throws InterruptedException {
        r.newCondition();
        new Thread(() -> {
            log.debug("read");
            w.lock();
            try {
                log.debug("read 已经获取");
                r.lock();
                log.debug("write 已经获取");
            } finally {
                r.unlock();
                w.unlock();

            }


        }, "t1").start();


    }
}
