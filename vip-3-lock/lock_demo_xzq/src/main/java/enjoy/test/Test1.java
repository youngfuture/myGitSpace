package enjoy.test;

import enjoy.entity.L;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "enjoy")
public class Test1 {


    static L l = new L();
    static  int i=0;

    public static void main(String[] args) throws InterruptedException {


        synchronized (l){
            i++;
            System.out.println(1/0);
        }
        //todo xxxxx


        synchronized (l){
            i++;
            System.out.println(1/0);
        }
    }







}
