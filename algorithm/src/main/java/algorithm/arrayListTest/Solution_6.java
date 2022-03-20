package algorithm.arrayListTest;

public class Solution_6 {

    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (!isMetaChar(chars[left])) {
                left++;
                continue;
            }

            if (!isMetaChar(chars[right])) {
                right--;
                continue;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }


    /**
     * 'a'、'e'、'i'、'o'、'u'
     */
    public boolean isMetaChar(char ch) {
        if (ch == 'a' || ch == 'a' - 32
                || ch == 'e' || ch == 'e' - 32
                || ch == 'i' || ch == 'i' - 32
                || ch == 'o' || ch == 'o' - 32
                || ch == 'u' || ch == 'u' - 32) {
            return true;
        }
        return false;
    }
}
