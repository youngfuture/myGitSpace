package ex9.gengric;

import java.util.List;

/**
 * 泛型的注意事项
 * JDK的编译器是可以通过（方法的特征： 返回类型+ 方法名+ param）
 */
public class Conflict {
//    public static String method(List<String> stringList){
//        System.out.println("List");
//        return "OK";
//    }

    public static Integer method(List<Integer> integerList){
        System.out.println("List");
        return 0;
    }
}
