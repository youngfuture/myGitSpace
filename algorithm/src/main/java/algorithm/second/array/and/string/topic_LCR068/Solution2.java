package algorithm.second.array.and.string.topic_LCR068;

/**
 * LCR 068. 搜索插入位置
 * <p>
 * link{https://leetcode.cn/problems/N6YdxV/solutions/1398925/cha-zhao-cha-ru-wei-zhi-by-leetcode-solu-inlw/}
 */
class Solution2 {
    /**
     * [left,right] 是闭区间
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * [left,right] 是闭区间
     */
    public int searchInsert2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * [left,right) 是左闭右开区间
     */
    public int searchInsert3(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
//        return right; 返回 left，right 都可以
    }


    /**
     * (left,right) 是开区间
     */
    public int searchInsert4(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}