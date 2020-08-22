package others;

import java.util.ArrayList;
/**
 * @author King老师
 */
public class HeapGC {
    byte[] _100KB = new byte[1024*100];//100KB
    public static void main(String[] args) throws Exception {
        ArrayList<HeapGC> heapGCS =new ArrayList<>();
        while (true){
            heapGCS.add(new HeapGC());
            Thread.sleep(10);
        }
    }
}

