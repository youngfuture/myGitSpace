package algorithm.binary.search;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int[] nums2 = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int target2 = 2;

        new Solution1().search(nums2, target2);
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        if (mid <= 0) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }
            return -1;
        }

        int result = 0;
        if (target == nums[mid]) {
            result = mid;
        } else if (target < nums[mid]) {
            result = recursion(nums, left, mid - 1, target);
        } else if (target > nums[mid]) {
            result = recursion(nums, mid + 1, right, target);
        }

        return result;
    }

    private int recursion(int[] nums, int i, int j, int target) {
        int left = i;
        int right = j;
        int mid = left + (right - left) / 2;
        if (mid <= 0) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }
            return -1;
        }

        int result = -1;
        if (target == nums[mid]) {
            result = mid;
        } else if (target < nums[mid]) {
            result = recursion(nums, left, mid - 1, target);
        } else if (target > nums[mid]) {
            result = recursion(nums, mid + 1, right, target);
        }
        return result;
    }


    public int search3(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
