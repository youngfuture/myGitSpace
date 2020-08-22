package ex2;
/**
 * @author King老师
 * VM参数
 * JVM对栈帧空间的优化
 *
 **/
public class JVMStack {

    public int work(int x) throws Exception{
        int z =(x+5)*10;//局部变量表有， 32位
        Thread.sleep(Integer.MAX_VALUE);
        return  z;
    }
    public static void main(String[] args)throws Exception {
        JVMStack jvmStack = new JVMStack();
        jvmStack.work(10);//10  放入main栈帧  10 ->操作数栈
    }
}
