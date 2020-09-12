package com.enjoy.test;

import com.enjoy.entity.A;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "enjoy")
public class TestJol {



    static Thread t1;
    static  Thread t2;
    static List<A> list = new ArrayList<A>();

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        A l = new A();




        t1 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                synchronized (l){
                    //轻量  偏向关闭
                    log.debug(ClassLayout.parseInstance(l).toPrintable());
                }
            }
        };

        t1.setName("t1");
        t1.start();
        t1.join();


        log.debug(ClassLayout.parseInstance(l).toPrintable());

    }




}
