package algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();

//      SlidingWindowMax.Solution solution=slidingWindowMax.new Solution();

        SlidingWindowMax.Solution2 solution = slidingWindowMax.new Solution2();


        System.out.println(solution.maxInWindows(num, 3));
    }


    public class Solution2 {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            if (num == null || size < 0) {
                return null;
            }

            ArrayList<Integer> list = new ArrayList<>();
            if (size == 0) {
                return list;
            }

            ArrayList<Integer> temp = null;
            int length = num.length;
            if (length < size) {
                return list;
            }

            /**
             * i < length - size + 1 ：循环
             */
            for (int i = 0; i < length - size + 1; i++) {
                temp = new ArrayList<>();
                for (int j = i; j < size + i; j++) {
                    temp.add(num[j]);
                }
                Collections.sort(temp);
                list.add(temp.get(temp.size() - 1));
            }

            return list;
        }
    }


    /**
     * 自己实现的方法：先顺序走，然后再反向走
     */
    public class Solution {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            ArrayList<Integer> maxList = new ArrayList<>();
            if (num.length <= 0) {
                return maxList;
            }

            int startOfWinByOrder = 0;
            int endOfWinByOrder;
            while (true) {
                endOfWinByOrder = startOfWinByOrder + (size - 1);
                if (endOfWinByOrder <= num.length - 1) {
                    int[] oneWinOrder = Arrays.copyOfRange(num, startOfWinByOrder, endOfWinByOrder + 1);
                    Integer max = getMaxNumFromWin(oneWinOrder);
                    if (max > 0) {
                        maxList.add(max);
                    }
                } else {
                    break;
                }
                startOfWinByOrder += 1;
            }

            int startOfWinByBack = num.length - 1;
            int endOfWinByBack;
            while (true) {
                endOfWinByBack = startOfWinByBack - (size - 1);
                if (endOfWinByOrder > endOfWinByBack) {
                    break;
                }
                int[] oneWinBack = Arrays.copyOfRange(num, endOfWinByBack, startOfWinByBack + 1);
                Integer max = getMaxNumFromWin(oneWinBack);
                if (max > 0) {
                    maxList.add(max);
                }
                startOfWinByBack -= 1;
            }
            return maxList;
        }

        private Integer getMaxNumFromWin(int[] oneWin) {
            int maxNum = 0;
            for (int i = 0; i < oneWin.length; i++) {
                if (oneWin[i] > maxNum) {
                    maxNum = oneWin[i];
                }
            }
            return maxNum;
        }
    }
}
