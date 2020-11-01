package com.enjoy;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "enjoy")
public class TestSync {

    static L l=null;
    public static void main(String[] args) throws InterruptedException {


        l= new L();


        Thread t1 = new Thread(() -> {
            try {
                count();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");


        Thread t2 = new Thread(() -> {
            try {
                count();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();


        Thread.sleep(5000);
        t2.start();


//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(()->{
//            count();
//        },"t2").start();





    }

    public static   void count() throws InterruptedException {

        synchronized (l) {
             log.debug(ClassLayout.parseInstance(l).toPrintable());
             TimeUnit.SECONDS.sleep(10);
        }


    }


}
