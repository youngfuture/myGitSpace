package algorithm.arrayListTest;

class Solution_10 {
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

            //表示没找到
            if (bound < 0) {
                bound = -bound - 1;
                //这里的bound也是答案的一种
            }

            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 到了就返回目标值得下标位置
     * 找不到就返回-(low + 1)，负数是为了返回没找到，但是第一个大于目标值值得位置信息，需要将返回值取反-1就得到第一个大于目标值得位置
     */
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

        //-(第一个大于目标值得下标位置 + 1)
        return -(low + 1);  // key not found.
    }
}