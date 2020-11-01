package enjoy.test;

import enjoy.entity.A;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "enjoy")
public class TestJol {

    static A a = new A();

    static Thread t1;
    static  Thread t2;
    static List<A> list = new ArrayList<A>();

    public static void main(String[] args) throws InterruptedException {
        
        t1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    //轻量  偏向关闭
                    log.debug(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };

        t1.setName("t1");
        t1.start();
        t1.join();


        log.debug(ClassLayout.parseInstance(a).toPrintable());

        Thread.interrupted();

    }




}
