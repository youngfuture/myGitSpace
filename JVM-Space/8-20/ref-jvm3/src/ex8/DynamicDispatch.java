package ex8;

/**
 * @author King老师
 * 动态分派（多态）
 */
public class DynamicDispatch {

    static abstract class Virus{ //病毒
        protected abstract void ill();//生病
    }
    static class Cold extends Virus{
        @Override
        protected void ill() {
            System.out.println("感冒了，好不舒服！");
        }
    }
    static class CoronaVirus extends Virus{//冠状病毒
        @Override
        protected void ill() {
            System.out.println("粘膜感染，空气传播，请带好口罩！");
        }
    }
    public static void main(String[] args) {

        Virus clod=new Cold();//感冒了
        clod.ill();
        System.out.println("hashcode:"+clod.hashCode());
        clod = new CoronaVirus();//（多态）
        System.out.println("hashcode:"+clod.hashCode());
        clod.ill();
    }
}
