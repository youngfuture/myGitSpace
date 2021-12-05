package algorithm.String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

//https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring/
public class MaxFreq_1297 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        return 0;


    }

    public static void main(String[] args) {
        System.out.println(new MaxFreq_1297().firstUniqChar("loveleetcode"));
        ;
    }

    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }

        }


        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }


        return -1;
    }
}
