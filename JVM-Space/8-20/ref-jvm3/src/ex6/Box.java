package ex6;
/**
 * @author King老师
 * 装箱拆箱字节码层面分析
 */
public class Box {
    public Integer cal() {
        Integer a = 1000;
        int b = a * 10;
        return b;
    }
}
