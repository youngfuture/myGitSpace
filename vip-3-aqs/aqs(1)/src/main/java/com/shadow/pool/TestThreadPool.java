package com.shadow.pool;

import lombok.extern.slf4j.Slf4j;
import sun.net.util.IPAddressUtil;

/**
 * @Author 钢牌讲师--子路
 **/
@Slf4j(topic = "e")
public class TestThreadPool {
    public static void main(String[] args) {
        CustomPool customPool = new CustomPool(2,((queue, task) -> {
            //queue.put(task);
            //task.run();
            throw new RuntimeException("xxxxx");
           // System.out.println("diu");
        }));
        for (int i = 0; i <5 ; i++) {
            int j = i;
            customPool.submitTask(new CustomTask("task"+i));
        }
    }
}
