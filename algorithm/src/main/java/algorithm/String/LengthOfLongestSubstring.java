package algorithm.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);

        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> characterSet = new HashSet<>();
        int tail = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                characterSet.remove(s.charAt(i - 1));
            }

            while (tail + 1 < s.length() && !characterSet.contains(s.charAt(tail + 1))) {
                characterSet.add(s.charAt(tail + 1));
                ++tail;
            }
            maxLength = Integer.max(maxLength, tail + 1 - i);

        }
        return maxLength;

    }


    /**
     * 最喜欢的解
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        Set<Character> characterSet = new HashSet<>();
        int tail = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                characterSet.remove(s.charAt(i - 1));
            }

            while (tail < s.length() && !characterSet.contains(s.charAt(tail))) {
                characterSet.add(s.charAt(tail));
                ++tail;
            }
            --tail;
            maxLength = Integer.max(maxLength, tail - i);

        }
        return maxLength;

    }

    //滑动窗口
    public int lengthOfLongestSubstring4(String s) {

        if (s.length() == 0) {
            return 0;
        }

        // key：字符 ；value：起始位置
        Map<Character, Integer> map = new HashMap<>();

        int startWin = 0;
        int maxSubLength = 0;
        int currentMaxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                currentMaxLength++;
            } else {
                if (currentMaxLength > maxSubLength) {
                    maxSubLength = currentMaxLength;
                }

                // 重复字符第一次出现的位置和窗口开始位置的最大值
                startWin = Math.max(map.get(s.charAt(i)), startWin);
                currentMaxLength = i - startWin;
                map.put(s.charAt(i), i);
            }
        }

        if (currentMaxLength > maxSubLength) {
            maxSubLength = currentMaxLength;
            return currentMaxLength;
        }

        return maxSubLength;
    }

    public static void main(String[] args) {
       String s = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring4(s));
    }

}
