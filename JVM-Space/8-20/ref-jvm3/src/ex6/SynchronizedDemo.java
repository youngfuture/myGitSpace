package ex6;
/**
 * @author King老师
 * 在 synchronized 生成的字节码中，其实包含两条 monitorexit 指令，是为了保证所有的异常条件，都能够退出
 * 这就涉及到了 Java 字节码的异常处理机制
 */
public class SynchronizedDemo {
    synchronized void m1(){
        System.out.println("m1");
    }
    static synchronized void m2(){
        System.out.println("m2");
    }
    final Object lock=new Object();

    void doLock(){
        synchronized (lock){
            System.out.println("lock");
        }
    }
}
