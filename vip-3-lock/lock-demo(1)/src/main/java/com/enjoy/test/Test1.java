package com.enjoy.test;

import com.enjoy.entity.L;
import com.enjoy.util.CASLock;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class Test1 {


    static  L l = new L();
    static  int i=0;

    public static void main(String[] args) throws InterruptedException {


        synchronized (l){
            i++;
            System.out.println(1/0);
        }
        //todo xxxxx


        synchronized (l){
            i++;
            System.out.println(1/0);
        }
    }







}
