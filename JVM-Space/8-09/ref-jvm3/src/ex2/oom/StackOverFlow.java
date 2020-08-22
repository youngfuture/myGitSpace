package ex2.oom;


/**
 * 栈溢出  -Xss=1m
 */
public class StackOverFlow {

    public void king(){//方法不断执行-栈帧不断入栈(不出栈)
        king();//
    }
    public static void main(String[] args)throws Throwable {
        StackOverFlow javaStack = new StackOverFlow();
        javaStack.king();
    }
}
