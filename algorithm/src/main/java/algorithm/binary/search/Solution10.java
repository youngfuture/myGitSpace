package algorithm.binary.search;

public class Solution10 {

    public int findMin(int[] nums) {
        int n = nums.length;

        int minTarget = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= minTarget) {
                minTarget = nums[i];
            } else {
                return minTarget;
            }
        }
        return minTarget;

    }
}
