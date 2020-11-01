package com.shadow.pool;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * @Author 钢牌讲师--子路
 */
@Slf4j(topic = "e")
public class CustomPool {

    RejectHandler handler;
    public  CustomQueue getCustomQueue() {
        return customQueue;
    }

    public  CustomQueue customQueue;

    private HashSet<Node> hashSet ;

    private int coreThreadSize;
    public CustomPool(int coreThreadSize,RejectHandler handler) {
        this.customQueue = new CustomQueue(2);
        this.hashSet = new HashSet<>();
        this.coreThreadSize = coreThreadSize;
        this.handler = handler;

    }






    public void submitTask(CustomTask runnable){
        /**
         * 1、如果hashSet.size<coreThreadSize 表示核心线程数还有空闲的直接执行
         */
        if(hashSet.size()<coreThreadSize){
            log.debug("当前核心线程数还有剩余");
            //先实例化一个node
            Node node = new Node(runnable,"t"+hashSet.size()+"",this);
            //然后把node添加到hashSet
            hashSet.add(node);
            log.debug("把线程添加到hashSet,start 线程[{}] 执行 [{}]",node.getName(),runnable.getName());
            node.start();
        }else {
            log.debug("当前核心线程数不够，则需要去队列当中去等待task[{}]",runnable.getName());
            customQueue.tryput(handler,runnable);
        }

    }


    public void removeSet(Node node){
        hashSet.remove(node);
    }

}
