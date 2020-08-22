package ex10;

/**
 *类说明：演示死锁的产生(这里只演示现象--原理在并发编专题课中)
 */
public class NormalDeadLock {

    private static Object No13 = new Object();//第一个锁
    private static Object No14 = new Object();//第二个锁

    //第一个拿锁的方法
    private static void peterDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (No13){
            System.out.println(threadName+" get NO13");
            Thread.sleep(100);
            synchronized (No14){
                System.out.println(threadName+" get NO14");
            }
        }
    }

    //第二个拿锁的方法
    private static void kingDo() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (No14){
            System.out.println(threadName+" get NO14");
            Thread.sleep(100);
            synchronized (No13){
                System.out.println(threadName+" get NO13");
            }
        }
    }

    //子线程，代表peter老师
    private static class Peter extends Thread{

        private String name;

        public Peter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            try {
                peterDo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //主线程，代表king老师
        Thread.currentThread().setName("Peter");
        Peter peter = new Peter("King");
        peter.start();
        kingDo();
    }

}
