package com.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 为了来学习wait notify/notifyall的使用
 *
 * 需要一把钥匙打开办公室的门
 *
 *
 * 关于wait notify 你就要注意一定配合 while
 */

@Slf4j(topic = "enjoy")
public class TestCondition {

    static Lock lock = new ReentrantLock();
    static boolean isWoman = false; // 女人
    static boolean isMoney = false; // 女人
    //支持多條件
    static Condition money = lock.newCondition();
    static Condition woman = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            lock.lock();
                while (!isMoney){
                    log.debug("没有发工资 不干活先去休息");
                    try {
                        //進入到money隊列阻塞
                        money.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("发工资了 开始工作 有钱能使鬼推mo");
                log.debug("xh幹完活回家");
            lock.unlock();
        }, "xh").start();

        new Thread(() -> {
            lock.lock();
                while (!isWoman){
                    log.debug("没有女人 我去等待老板安排  先休息，安排好之后叫醒我");
                    //释放锁
                    try {
                        woman.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("开始工作，男女搭配干活不累");
                log.debug("幹完活回家");
            lock.unlock();
        }, "xm").start();






       // TimeUnit.NANOSECONDS.sleep(10);
        //主要是为了说明 wait会释放锁
//        for (int i = 0; i <5 ; i++) {
//            new Thread(() -> {
//                synchronized (object){
//                    log.debug("五个其他人干活");
//                }
//            }, "t"+i).start();
//        }


        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            lock.lock();
                startThreads();//队列当中是没有人排队的
                isWoman=true;
                log.debug("找了新垣结衣，来了你起来干活");
                //小明他不會立馬得到鎖 不會立馬執行 他會去park
                woman.signal();

                isMoney=true;
                log.debug("工资也发了");
                money.signal();
           lock.unlock();
        }, "boss").start();

    }


    public static void startThreads(){

        for (int i = 0; i <5 ; i++) {
            new Thread(() -> {
                //t1---t5 都会进入队列 去阻塞
                lock.lock();
                log.debug("--------");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }, "t"+i).start();
        }
    }
}
