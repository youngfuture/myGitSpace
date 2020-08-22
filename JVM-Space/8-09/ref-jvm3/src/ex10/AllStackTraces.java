package ex10;

import java.util.Map;

/**
 * @author 【享学课堂】 King老师
 * VM Args：-Xms20m -Xmx20m -Xmn2m -XX:+PrintGC
 * 如果无法连接服务器，也可以使用java.lang.Thread类的getAllStackTraces（）方法用于获取
 */
public class AllStackTraces {
    //填充数据，造成GC
    public static void main(String[] args) {
        while (true){
            byte[]b=null;
            for(int i=0;i<10;i++){
                b=new byte[1*1024*1024];
            }
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //于获取虚拟机中所有线程的StackTraceElement对象
            Map<Thread,StackTraceElement[]> threadMap = Thread.getAllStackTraces();
            for(Map.Entry<Thread,StackTraceElement[]> entry:threadMap.entrySet()){
                Thread t = entry.getKey();
                StackTraceElement[] ss = entry.getValue();
                //打印线程信息
                System.out.println(t.getName()+"-"+t.getId());
                for (StackTraceElement s: ss){ //打印线程详情信息
                    System.out.println(s);
                }
            }
        }
    }
}
