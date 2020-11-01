package com.shadow.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Author 钢牌讲师--子路
 */

@Slf4j(topic = "e")
public class CustomQueue {

    /**
     * 双向链表
     */
    Deque<CustomTask> deque = new ArrayDeque<>();

    /**
     * 锁
     */
    ReentrantLock lock = new ReentrantLock();

    Condition busyws = lock.newCondition();

    Condition emptyws = lock.newCondition();

    int capcity;
    long timeOut = 1000l;




    public CustomQueue(int capcity) {
        this.capcity = capcity;
    }

    /**
     * 有策略
     * @param handler
     * @param task
     * @throws InterruptedException
     */
    public void tryput(RejectHandler handler,CustomTask task)  {
        lock.lock();
        try {
            if (deque.size()==capcity){
                handler.handler(this,task);
            }else{
                log.debug("加入任务队列 {}", task);
                log.debug("足够,则加入队列中---task[{}]",task.getName());
                deque.addLast(task);
                emptyws.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    /**
     * 如果队列满了则一直等
     * @param task
     * @throws InterruptedException
     */
    public void put(CustomTask task) throws InterruptedException {
       lock.lock();
       try{
           log.debug("put之前先判断容量是否足够 task[{}]",task.getName());
           while (deque.size()==capcity){
               log.debug("队列容量不够则阻塞--task[{}[",task.getName());
               busyws.await();
           }
           log.debug("足够,则加入队列中---task[{}]",task.getName());
           deque.addLast(task);
           emptyws.signal();
       }finally {
           lock.unlock();
       }

    }

    public CustomTask poll(){
       lock.lock();
       try {
           /**
            * 获取一个taks
            * 首先得判断这个队列是否为空
            */
           long nanos =TimeUnit.NANOSECONDS.toNanos(timeOut);
           while (deque.isEmpty()){
               log.debug("poll一个任务但是队列当中为null 则阻塞");
               if(nanos <= 0l){
                   log.debug("解阻塞");
                    return null;
               }
               try {
                   nanos = emptyws.awaitNanos(nanos);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }

           CustomTask task = deque.removeFirst();
           log.debug("poll一个任务正常 --- task[{}]",task.getName());
           busyws.signal();
           return task;
       }finally {
           lock.unlock();
       }
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
