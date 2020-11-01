package com.shadow.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author 钢牌讲师--子路
 **/
@Slf4j(topic = "e")
public class Test {
    static ThreadPoolExecutor executor;
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(
                () -> {
                    log.debug("start");
                    TimeUnit.MILLISECONDS.sleep(1500);
                    log.debug("end");
                    return "a";
                }, () -> {
                    log.debug("start");
                    TimeUnit.MILLISECONDS.sleep(500);
                    log.debug("end");
                    return "b";
                }, () -> {
                    log.debug("start");
                    TimeUnit.MILLISECONDS.sleep(2500);
                    log.debug("end");
                    return "c";
                }
        ));

        futures.forEach(f->{
            try {
                log.debug("result:{}",f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });




//        for (int i = 0; i <3 ; i++) {
//            Future<String> submit = executor.submit(() -> {
//
//                return "success";
//            });
//        }


    }

    private static void test2() throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(()->{
            log.debug("start put 1");
            try {
                synchronousQueue.put("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("end put 1");


            log.debug("start put 2");
            try {
                synchronousQueue.put("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("end put 2");

        },"t1").start();


        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            log.debug("start take 1");
            try {
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("end take 1");


        },"t2").start();
    }

    private static void test1() {
        executor = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
        for (int i = 0; i <3 ; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
        }
    }


    static class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            log.debug("线程数目{}", executor.getActiveCount());
            log.debug("线程名称：{} 正在执行task{}", Thread.currentThread().getName(), taskNum);
            try {
                Thread.currentThread().sleep(1000);
                log.debug("线程数目{}", executor.getActiveCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task{}执行完毕", taskNum);
        }
    }
}
