package ex8;
/**
 * @author 【享学课堂】 King老师
 * 虚方法表
 **/
public class Dispatch {
    static class QQ{}
    static class WX{}
    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }
        public void hardChoice(WX arg){
            System.out.println("father choose weixin");
        }
    }
    public static class Son extends Father{
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }
        public void hardChoice(WX arg){
            System.out.println("son choose weixin");
        }
    }
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new WX());
        son.hardChoice(new QQ());
    }
}
