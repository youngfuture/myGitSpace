package com.shadow.poolv1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 钢牌讲师--子路
 **/
@Slf4j(topic = "e")
public class TestPool {
    public static void main(String[] args) {

       EnjoyThreadPool enjoyThreadPool = new EnjoyThreadPool(2);


        for (int i = 0; i <5 ; i++) {
            enjoyThreadPool.submitTask(new CustomTask("task"+i));
        }


    }
}
