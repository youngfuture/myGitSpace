package enjoy.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        int N = 10;
        Thread[] threads = new Thread[N];
        for(int i = 0; i < N; ++i){
            threads[i] = new Thread(new Runnable(){
                public void run() {
                    //synchronized ()
                    /**
                     *
                     * 独占锁---顾名思义
                     * t1------t9全部在这里阻塞
                     * 非公平锁也是拿不到锁---阻塞---进入队列---
                     * 线程
                     */
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " lock!");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    lock.unlock();
                }

            });
        }
        //synchronized ()
        lock.lock();
        for(int i = 0; i < N; ++i){
            threads[i].start();
            Thread.sleep(200);
        }
        lock.unlock();

        for(int i = 0; i < N; ++i)
            threads[i].join();
    }
}
