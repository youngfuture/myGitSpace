package main.java.algorithm.offer;

//剑指 Offer 42. 连续子数的最大和
public class MaxSubArray_42 {

    public int maxSubArray(int[] nums) {
        //子数组只有一个数
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //如果数组的前一个数字是负数，则当前最大值就是自己
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] += Math.max(dp[i - 1], 0);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }


}
