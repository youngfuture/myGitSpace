package ex8;
/**
 * @author 【享学课堂】 King老师
 * 接口的调用字节码查看
 **/
public class Invoke implements I {
    @Override
    public void inf() { }
    public static void main(String[] args) throws Exception {
        Invoke invoke = new Invoke();
        ((I) invoke).inf();

    }
}
