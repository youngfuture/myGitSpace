package algorithm.offer;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&&tqId=11195&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 输出描述: 对应每个测试案例，输出两个数，小的先输出。
 *
 * 思路：
 *     这个题目就是双指针，相向而行，如果如果 S 小于两个的和，肯定是右边的数变小才满足，所以左移动
 *     如果 S 大于两个的和，肯定需要左边数变大，右移动
 *
 *     举一反三：
 *     1.输出所有满足和正好是S的序列，找到了所有满足的序列，选择输出那些可以变化
 *     2.输出所有满足两个数的和 大于或者小于或等于 S值的序列
 *     3.题目中的序列没有排序，需要自己先排序
 *     4.题目中的序列有重复需要加上重复逻辑
 *
 *
 */
public class FindNumbersWithSumJZ42 {


    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

            if (array.length == 0) {
                return new ArrayList<>();
            }

            int minMutile = Integer.MAX_VALUE;

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0, j = array.length - 1; i < array.length && j >= 0; ) {
                int left = array[i];
                int right = array[j];

                if (i == j) {
                    break;
                }

                if (left + right == sum) {
                    if (minMutile > left * right) {
                        list.clear();
                        list.add(left);
                        list.add(right);
                        minMutile = left * right;
                    }
                    j--;
                    i++;
                    continue;
                }

                if (left < sum && sum < (left + right)) {
                    j--;
                }

                if (left < sum && sum > (left + right)) {
                    i++;
                }
            }
            return list;
        }
    }
}
