package ex9.gengric;

/**
 * 为什么需要泛型
 */
public class NeedGeneric {

    public int addInt(int x,int y){
        return x+y;
    }

    public float addFloat(float x,float y){
        return x+y;
    }
    public Double addDouble(Double x,Double y){
        return x+y;
    }

    public static void main(String[] args) {
        //不使用泛型
        NeedGeneric needGeneric = new NeedGeneric();
        System.out.println(needGeneric.addInt(1,2));
        System.out.println(needGeneric.addFloat(1.2f,2.4f));

        //使用泛型
        System.out.println(needGeneric.add(1,2));
        System.out.println(needGeneric.add(1.2d,2.4d));

    }

//    //泛型方法
    public <T extends Number> double add(T x,T y){
        return x.doubleValue()+y.doubleValue();
    }
}
