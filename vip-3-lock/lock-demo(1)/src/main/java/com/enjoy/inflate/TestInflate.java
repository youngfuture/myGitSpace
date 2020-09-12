package com.enjoy.inflate;


import com.enjoy.entity.A;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "enjoy")
public class TestInflate {

    static  Thread t2;
    static Thread t3;
    static Thread t1;
    static int loopFlag=38;
    public static void main(String[] args) throws InterruptedException {
//        //101  可偏向 没有线程偏向
//
//        //a 没有线程偏向---匿名    101偏向锁
//        List<A> list = new ArrayList<>();
//
//        t1 = new Thread(){
//           @Override
//           public void run() {
//               for(int i=0;i<loopFlag;i++){
//                A a = new A();
//                list.add(a);
//                synchronized (a){
//                    log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                }
//               }
//
//               log.debug("=========================");
//               LockSupport.unpark(t2);
//           }
//
//
//       };
//
//
//
//      // t2.join();
//
//
//        t2 = new Thread(){
//
//            @Override
//            public void run() {
//                LockSupport.park();
//                    for (int i = 0; i <30 ; i++) {
//                        A a = list.get(i);
//                        log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                        synchronized (a){
//                            log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                        }
//                        log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                    }
//
//                log.debug("======t3=====================================");
//                LockSupport.unpark(t3);
//
//            }
//        };
//
//
//
//
//        t3 = new Thread(){
//
//
//
//
//            @Override
//            public void run() {
//                LockSupport.park();
//                for (int i = 0; i <loopFlag ; i++) {
//                    A a = list.get(i);
//                    log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                    synchronized (a){
//                        log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                    }
//                    log.debug(i+" "+ClassLayout.parseInstance(a).toPrintableTest(a));
//                }
//            }
//        };
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t3.join();
//
//        log.debug(ClassLayout.parseInstance(new A()).toPrintable());
        aa();
    }


    public static void aa() throws InterruptedException {
        A a= new A();
        Thread t = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    log.debug(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        t.start();
        t.join();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    log.debug(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        t1.start();
        t1.join();
//        synchronized (a){
//            log.debug(ClassLayout.parseInstance(a).toPrintable());
//        }
    }

}
