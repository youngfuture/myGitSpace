package algorithm.arrayListTest;


import java.util.Arrays;

public class Solution_8 {

    /**
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
     */
    public static void main(String[] args) {
        System.out.println(new Solution_8().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }


    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, n = nums.length;
        int ans = Integer.MAX_VALUE;
        while (left <= right && right < n) {
            int sumOfWindow = sumSubArrays(nums, left, right);
            if (sumOfWindow >= target) {
                ans = Math.min(ans, right - left + 1);
                left++;
            } else {
                right++;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;

    }

    private int sumSubArrays(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return nums[left];
        }

        int sum = 0;
        for (int i = left; i <= right && i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }


    /**
     * 11
     * [1,2,3,4,5]
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }

            int ans = Integer.MAX_VALUE;

            /**
             * 为了方便计算，令 size = n + 1
             * 其中 sums[i]       表示从 nums[0]到 nums[i-1]的元素和
             * sums[0] = 0       表示前 0 个元素的前缀和为 0
             * sums[1] = nums[0] 表示前 1 个元素的前缀和为 nums[0]
             * 以此类推
             */
            int[] sums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                //nums[i - 1] 表示第i个元素，因为从下标0开始计算
                sums[i] = sums[i - 1] + nums[i - 1];
            }


            for (int i = 1; i <= n; i++) {
                int searchValue = target + sums[i - 1];

                //此处的 sums[bound] 表示前 bound个值的和，bound为下标
                //sums[i - 1] + target <= sums[bound]

                int bound = binarySearch(sums, 0, sums.length, searchValue);
                if (bound < 0) {
                    bound = -bound - 1;
                }

                if (bound <= n) {
                    ans = Math.min(ans, bound - (i - 1));
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

        private Integer binarySearch(int[] a, int fromIndex, int toIndex,
                                     int key) {
            int low = fromIndex;
            int high = toIndex - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = a[mid];

                if (midVal < key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
                else
                    return mid; // key found
            }
            return  -(low + 1);  // key not found.
        }
    }
}
