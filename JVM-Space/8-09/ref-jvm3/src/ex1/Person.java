package ex1;

/**
 * @author King老师
 * 栈帧执行对内存区域的影响
 */
public class Person {
    public  int work()throws Exception{
        int x =1;
        int y =2;
        int z =(x+y)*10;
        return  z;
    }
    public static void main(String[] args) throws Exception{
        Person person = new Person();//person 栈中--、  new  Person  对象是在堆
        person.work();

    }
}
