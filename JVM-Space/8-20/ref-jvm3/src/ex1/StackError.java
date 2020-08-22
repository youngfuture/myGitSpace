package ex1;
/**
 * @author King老师
 * 虚拟机栈溢出 -Xss
 */
public class StackError {
    public static void main(String[] args) {
        A();
    }
    public static void A(){
        A();
    }
}
