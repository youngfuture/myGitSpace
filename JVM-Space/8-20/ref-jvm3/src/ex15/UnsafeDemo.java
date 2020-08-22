package ex15;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
/**
 * @author King老师
 * 参数无效：-XX:MaxDirectMemorySize=10m
 */
public class UnsafeDemo {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        long addr = unsafe.allocateMemory(100*_1MB);
    }
}
