package ex14.heap;

/**
 * Shallow Heap Vs Retained Heap
 */

class A {
    private static byte[] b = new byte[10*1000];
    private B b1 = new B();
    private C c1 = new C();
}
class B {
    private D d1 = new D();
    private E e1 = new E();
}
class C {
    private F f1 = new F();
    private G g1 = new G();
}
class D {
}
class E {
}
class F {
}
class G {
}

public class MATHeap {
    public static void main(String[] args) throws Exception {
        A a = new A();
        Thread.sleep(Integer.MAX_VALUE);//线程休眠
    }
}
