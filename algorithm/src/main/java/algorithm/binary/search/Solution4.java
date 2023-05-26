package algorithm.binary.search;

public class Solution4 {
    public static void main(String[] args) {
        int nums[] = new int[]{5, 7, 7, 8, 8, 10};
        new Solution4().searchRange(nums, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;
        int targetIndex = 0;

        while (left < right) {
            if (nums[left] == target) {
                result[0] = left;
                targetIndex = left;
                break;
            }

            if (nums[right] == target) {
                targetIndex = right;
                break;
            }

            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (nums[targetIndex] != target) {
            return result;
        }

        for (int i = targetIndex; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }else {
                result[1] = i;
            }
        }

        for (int j = targetIndex; j >= 0; j--) {
            if (nums[j] != target) {
                break;
            } else {
                result[0] = j;
            }
        }
        return result;
    }
}
