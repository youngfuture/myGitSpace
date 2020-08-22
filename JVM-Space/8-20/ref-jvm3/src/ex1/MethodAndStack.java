package ex1;
/**
 * @author King老师
 * JAVA方法的运行与虚拟机栈
 */
public class MethodAndStack {
    public static void main(String[] args) {
        A();
    }
    public static void A(){
        B();
    }
    public static void B(){
        C();
    }
    public static void C(){

    }
}
