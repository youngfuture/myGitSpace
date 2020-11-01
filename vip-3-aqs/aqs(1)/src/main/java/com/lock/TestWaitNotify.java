package com.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 为了来学习wait notify/notifyall的使用
 *
 * 需要一把钥匙打开办公室的门
 *
 *
 * 关于wait notify 你就要注意一定配合 while
 */

@Slf4j(topic = "enjoy")
public class TestWaitNotify {

    static  Object object = new Object();
    static boolean isWoman = false; // 女人
    static boolean isMoney = false; // 女人

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (object){
                while (!isMoney){
                    log.debug("没有发工资 不干活先去休息");
                    try {
                        //只支持單個條件
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("发工资了 开始工作 有钱能使鬼推mo");
                log.debug("xh幹完活回家");
            }
        }, "xh").start();

        new Thread(() -> {
            synchronized (object){
                while (!isWoman){
                    log.debug("没有女人 我去等待老板安排  先休息，安排好之后叫醒我");
                    //释放锁
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("开始工作，男女搭配干活不累");
                log.debug("幹完活回家");
            }
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
            synchronized (object){
                isWoman=true;
                log.debug("找了新垣结衣，来了你起来干活");

                isMoney=true;

                log.debug("工资也发了");
                //随机叫醒一个
                object.notify();

                object.notifyAll();
            }
        }, "boss").start();

    }
}
