package ex2.oom;

import java.nio.ByteBuffer;

/**
 * @author King老师
 * VM Args：-XX:MaxDirectMemorySize=100m
 * 限制最大直接内存大小100m
 */
public class DirectOom {
    public static void main(String[] args) {
        //直接分配128M的直接内存
        ByteBuffer bb = ByteBuffer.allocateDirect(128*1024*1204);
    }
}
