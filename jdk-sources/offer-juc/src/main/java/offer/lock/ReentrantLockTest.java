package offer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public ReentrantLock reentrantLock = new ReentrantLock();
    public Condition condition = reentrantLock.newCondition();

    public volatile int money = 100;

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();


        int count = 1000;

        //花钱
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    reentrantLockTest.spendMoney();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        //挣钱
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                reentrantLockTest.earnMoney();
            }).start();
        }

    }


    public void spendMoney() throws InterruptedException {
        reentrantLock.lock();
        while(true){
            if(money>0){
                money--;
                System.out.println("我花了 1 块钱，当前余额：" + money);
                break;
            }else {
                condition.await();
            }
        }
        reentrantLock.unlock();
    }

    public void earnMoney() {
        reentrantLock.lock();
        money++;
        System.out.println("我挣了 1 块钱，当前余额：" + money);
        condition.signal();
        reentrantLock.unlock();

    }

}
