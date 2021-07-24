package main.java.algorithm.leedcode;

public class ReverseString_344 {

    //["h","e","l","l","o"]
    public void reverseString(char[] s) {

        for (int i = 0, j = s.length - 1; i < s.length; i++, j--) {
            if (i > j) {
                break;
            }
            char tempChar = s[i];
            s[i] = s[j];
            s[j] = tempChar;
        }

    }
}
