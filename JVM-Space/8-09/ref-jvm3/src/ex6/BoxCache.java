package ex6;
/**
 * @author King老师
 * IntegerCache及修改
 * -XX:AutoBoxCacheMax=256
 */


public class BoxCache {
    public static void main(String[] args) {
        Integer n1 = 123; //new一东西
        Integer n2 = 123;
        Integer n3 = 128;
        Integer n4 = 128;

        System.out.println(n1 == n2);
        System.out.println(n3 == n4);
    }
}
