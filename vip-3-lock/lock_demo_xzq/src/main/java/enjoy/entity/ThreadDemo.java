package enjoy.entity;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.currentThread().join();
    }

}
