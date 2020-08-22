package ex9.gengric;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型擦除
 */
public class Theory {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("King","18");
        System.out.println(map.get("King"));
    }
}
