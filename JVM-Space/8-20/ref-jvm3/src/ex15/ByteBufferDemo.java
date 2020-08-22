package ex15;

import java.nio.ByteBuffer;

/**
 * @author King老师
 * VM Args：-XX:MaxDirectMemorySize=100m
 * 限制最大直接内存大小100m
 * -XX:MaxDirectMemorySize=128m
 * -Xmx128m
 * -Xmx135m -Xmn100m -XX:SurvivorRatio=8
 * -Xmx138m -Xmn100m -XX:SurvivorRatio=8
 */
public class ByteBufferDemo {
    static ByteBuffer bb;
    public static void main(String[] args) throws Exception {
        //直接分配128M的直接内存
        bb = ByteBuffer.allocateDirect(128*1024*1024);
    }
}
