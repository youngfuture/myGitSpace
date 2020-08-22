package ex3;
/**
 * @author King老师
 * 逃逸分析-栈上分配
 * -XX:-DoEscapeAnalysis -XX:+PrintGC
 */
public class EscapeAnalysisTest {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {//5000万次---5000万个对象
            allocate();
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
        Thread.sleep(600000);
    }

    static void allocate() {//逃逸分析（不会逃逸出方法）
        //这个myObject引用没有出去，也没有其他方法使用
        MyObject myObject = new MyObject(2020, 2020.6);
    }

    static class MyObject {
        int a;
        double b;

        MyObject(int a, double b) {
            this.a = a;
            this.b = b;
        }
    }
}
