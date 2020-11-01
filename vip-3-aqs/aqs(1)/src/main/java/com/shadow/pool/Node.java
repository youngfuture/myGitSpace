package com.shadow.pool;

import com.sun.corba.se.impl.oa.toa.TOA;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Author 钢牌讲师--子路
 */
@Slf4j(topic = "e")
public class Node extends Thread{
    ReentrantLock nodel = new ReentrantLock();
    CustomPool customPool;
    CustomQueue customQueue;
    CustomTask target;
    public Node(CustomTask target,String tname,CustomPool customPool) {
        setName(tname);
        this.target=target;
        this.customPool = customPool;
        customQueue= customPool.getCustomQueue();
    }

    @Override
    public void run() {
        //customQueue.getLock().lock();

            /**
             * 这里不能直接执行任务
             * 需要分情况
             * 1、如果是传过来的task则直接执行，执行完成之后
             * 2、判断阻塞队列当中是否有task，如果有则取出来执行
             * 首先判断target是否等于null，不等于null则表示传过来的
             * 执行完后把target设置为null
             */
            while (target != null || (target = customQueue.poll()) != null) {
                log.debug("runing--task[{}]", target.getName());
                target.run();
                target = null;
            }
            //最后如果队列当中的也都执行完了则需要把当前线程从 poll里面移除

            customPool.removeSet(this);

           // customQueue.getLock().unlock();


    }
}
