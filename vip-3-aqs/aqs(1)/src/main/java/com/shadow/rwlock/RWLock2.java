package com.shadow.rwlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁的上锁流程
 */
@Slf4j(topic = "enjoy")
public class RWLock2 {
    //读写锁
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    /**
     * 保护共享变量 ----多个线程 修改  锁   理论也要加锁 70% 读
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {

        Thread tn = new Thread(() -> {
            r.lock();
            r.unlock();
        }, "tn");
        tn.start();
    }








}
