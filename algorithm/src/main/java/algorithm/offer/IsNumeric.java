package algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
    public static void main(String[] args) {
        String str = "+100";
        System.out.println(new IsNumeric().isNumeric(str.toCharArray()));
    }


    public boolean isNumeric(char[] str) {
        Map<Character, Character> charMap = new HashMap();
        Map<Character, Character> charMap2 = new HashMap();
        charMap.put('1', '1');
        charMap.put('2', '2');
        charMap.put('3', '3');
        charMap.put('4', '4');
        charMap.put('5', '5');
        charMap.put('6', '6');
        charMap.put('7', '7');
        charMap.put('8', '8');
        charMap.put('9', '9');
        charMap.put('0', '0');

        charMap2.put('1', '1');
        charMap2.put('2', '2');
        charMap2.put('3', '3');
        charMap2.put('4', '4');
        charMap2.put('5', '5');
        charMap2.put('6', '6');
        charMap2.put('7', '7');
        charMap2.put('8', '8');
        charMap2.put('9', '9');
        charMap2.put('0', '0');

        charMap.put('+', '+');
        charMap.put('-', '-');
        charMap.put('.', '.');
        charMap.put('e', 'e');
        charMap.put('E', 'E');
        for (int i = 0; i < str.length; i++) {
            if (charMap.get(str[i]) == null) {
                return false;
            }
            if ((str[i] == '+' || str[i] == '-') && i == 0) {
                continue;
            } else {
                return false;
            }

            if (str[i] == '.') {
                if(i==str.length-1){
                    return false;
                }
                if( charMap2.get(str[i - 1]) == null){
                    return  false;
                }


                if(charMap2.get(str[i+ 1]) == null){
                    return false
                }

            }


            if (str[i] == 'e' || str[i] == 'E') {
                if (charMap2.get(str[i - 1]) == null) {
                    return false;
                }else {
                    for (int j = i + 1; j < str.length; j++) {
                        if (j == i + 1) {
                            if (str[j] == '+' || str[j] == '-') {
                                if (charMap2.get(str[j + 1]) != null && j + 1 < str.length) {
                                    continue;
                                } else {
                                    return false;
                                }
                            }
                        }
                        if (charMap2.get(str[j]) != null) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }

        }


    }


        return true;

}
}
