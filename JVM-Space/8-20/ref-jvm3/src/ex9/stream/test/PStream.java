package ex9.stream.test;

import java.util.ArrayList;
import java.util.List;
/**
 * @author King老师
 * 测试parallelStream线程池线程数仅为cpu的核心数
 */
public class PStream {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(1);
        }
        //parallelStream的地方都是使用同一个Fork-Join线程池，而线程池线程数仅为cpu的核心数
        //可以通过一下配置修改这个值
       // System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
        for (int i = 1; i <= 50; i++) {
            new Thread("test-" + i) {
                String currentThreaName = this.getName();
                @Override
                public void run() {
                    list.parallelStream()
                            .forEach(numbser -> {
                                Thread c = Thread.currentThread();
                                System.out.println(currentThreaName + "===> "
                                        + c.getClass().getName() + ":" + c.getName() + ":" + c.getId());
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            });
                }
            }.start();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }
}
