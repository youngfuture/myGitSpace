package algorithm.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 牛客地址：https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FindFirstUnrepeatableCharFromString {

    /**
     * java 最优解
     */
    class SolutionBeastJava {
        int count[] = new int[256];
        //Insert one char from stringstream
        int index = 1;

        /**
         * 越往后面的值，index越大，且都是大于1，第一个字符出现一次 count[ch]=1，第二个字符出现一次 count[ch]=2
         * index 巧妙的设计成大于1表示出现过，且出现的越晚越大，非常巧，index 一个变量有2种含义
         */

        public void Insert(char ch) {
            if (count[ch] == 0) {
                count[ch] = index++;
            } else {
                count[ch] = -1;
            }
        }

        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce() {
            int temp = Integer.MAX_VALUE;
            char ch = '#';
            for (int i = 0; i < 256; i++) {
                if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
                    temp = count[i];
                    ch = (char) i;
                }
            }
            return ch;
        }
    }

    class Solution3 {
        //仿照hash表实现，str存储插入的字符，hash[256]存储插入字符的个数
        List<Character> strList = new ArrayList<Character>();
        char hash[] = new char[256];

        void Insert(char ch) {
            strList.add(ch);
            hash[ch]++;
        }

        //遍历插入的字符（按照插入的顺序，可方便的得到第一个），hash表中个数为1的输出，否则返回#
        char FirstAppearingOnce() {
            for (char ch : strList)
                if (hash[ch] == 1)
                    return ch;
            return '#';
        }
    }

    class Solution2 {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        ArrayList<Character> list = new ArrayList<Character>();

        //Insert one char from stringstream
        public void Insert(char ch) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            list.add(ch);
        }

        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce() {
            char c = '#';
            for (char key : list) {
                if (map.get(key) == 1) {
                    c = key;
                    break;
                }
            }

            return c;
        }
    }

    class Solution1 {

        //Insert one char from stringstream
        String input = "";
        Map<Character, Integer> map = new HashMap<>();

        public void Insert(char ch) {
            if (!map.keySet().contains(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
            input += ch;
        }

        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce() {
            int index = Integer.MAX_VALUE;
            char result = '#';
            for (Character c : map.keySet()) {
                if (map.get(c) == 1) {
                    if (input.indexOf(c) < index) {
                        index = input.indexOf(c);
                        result = input.charAt(index);
                    }
                }
            }
            return result;
        }
    }


}
