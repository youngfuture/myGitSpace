package algorithm.second.array.and.string.topic_1991;

import java.util.Arrays;

/**
 * link{https://leetcode.cn/problems/find-the-middle-index-in-array/description/}
 * 遍历每个元素两边的和是否相等，可以硬算
 * 先求总和，利用公司 2*sum+num[i] =total从左往右计算，先求总数这个很关键
 * <p>
 * 从左往右一个一个尝试
 * 逐个求nums[0]...nums[i-1]=sum 的和
 * 判断是否满足条件
 * 第一个满足的就是题目中满足条件的最左边的一个
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int total = 0;
        for (int k = 0; k < nums.length; k++) {
            total += nums[k];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //先比较，再累加，边界问题
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}