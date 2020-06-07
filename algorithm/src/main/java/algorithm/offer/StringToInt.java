package algorithm.offer;

import java.util.HashMap;

public class StringToInt {

    public static void main(String[] args) {
        String demoStr = "4536507";
        System.out.println(new StringToInt().StrToInt(demoStr));

    }

    public int StrToInt(String str) {
        HashMap<Character, Integer> charToIntegerMap = new HashMap<>();
        charToIntegerMap.put('0', 0);
        charToIntegerMap.put('1', 1);
        charToIntegerMap.put('2', 2);
        charToIntegerMap.put('3', 3);
        charToIntegerMap.put('4', 4);
        charToIntegerMap.put('5', 5);
        charToIntegerMap.put('6', 6);
        charToIntegerMap.put('7', 7);
        charToIntegerMap.put('8', 8);
        charToIntegerMap.put('9', 9);

        int index = 1;
        int sum = 0;
        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            char ch = str.charAt(i);
            if (ch > '9' || ch < '0') {
                return 0;
            }
            for (int k = 0; k < j; k++) {
                index *= 10;
            }
            sum += charToIntegerMap.get(ch) * index;
            index = 1;
        }
        return sum;
    }

}
