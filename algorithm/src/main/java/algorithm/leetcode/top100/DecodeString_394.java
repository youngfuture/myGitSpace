package algorithm.leetcode.top100;

public class DecodeString_394 {

    public static void main(String[] args) {
        //System.out.println(new DecodeString_394().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString_394().decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        if (onlyString(s)) {
            return s;
        }

        int index = 0;
        int len = s.length();

        StringBuilder res = new StringBuilder();
        while (index < len) {
            char ch = s.charAt(index);
            if ('a' <= ch && ch <= 'z') {
                res.append(ch);
                index++;
            } else {
                int num = 0;
                int left = index;
                int right = index;
                while (right < len && s.charAt(right) >= '0' && s.charAt(right) <= '9')
                    right++;
                num = Integer.parseInt(s.substring(left, right));
                left = right;
                right++;
                int leftP = 1;
                while (leftP != 0) {
                    char temp = s.charAt(right);
                    if (temp == '[') {
                        leftP++;
                    } else if (temp == ']') {
                        leftP--;
                    }

                    if (leftP == 0)
                        break;
                    right++;
                }

                String smallFrac = decodeString(s.substring(left + 1, right));
                for (int i = 0; i < num; i++)
                    res.append(smallFrac);

                index = right + 1;
            }
        }

        return res.toString();
    }

    public boolean onlyString(String s) {
        int index = 0;
        while (index != s.length()) {
            char ch = s.charAt(index);

            if (ch == '[' || ch == ']')
                return false;
            index++;
        }

        return true;
    }
}
