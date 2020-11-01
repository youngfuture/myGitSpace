package com.lock;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.tools.ToolProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "enjoy")
public class Test {
    static boolean isRun=false;
    static int i=0;
    static int k=0;
    static int c=0;
    static List list = new ArrayList();
    public static void main(String[] args) throws InterruptedException {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isRun=true;
                System.out.println(isRun);
            }).start();




            while (true){

                log.debug("xxxxxxxxxxxx");

                //list.add(i);
                if(isRun){
                    log.debug("--------");
                }
            }


    }
}
