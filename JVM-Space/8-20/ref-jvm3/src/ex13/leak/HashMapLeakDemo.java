package ex13.leak;

import java.util.HashMap;
import java.util.Map;

public class HashMapLeakDemo {
            public static class Key {
                String title;

                public Key(String title) {
                    this.title = title;
                }
            }

            public static void main(String[] args) {
                Map<Key, Integer> map = new HashMap<>();

                map.put(new Key("1"), 1);
                map.put(new Key("2"), 2);
                map.put(new Key("3"), 2);

                Integer integer = map.get(new Key("2"));
                System.out.println(integer);
            }
        }