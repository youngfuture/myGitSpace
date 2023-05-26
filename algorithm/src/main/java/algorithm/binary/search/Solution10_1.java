package algorithm.binary.search;

public class Solution10_1 {
    public static void main(String[] args) {
        //new Solution10_1().findMin(new int[]{1, 3, 5});
        //new Solution10_1().findMin(new int[]{2, 2, 2, 0, 1});
        //new Solution10_1().findMin(new int[]{1, 1});
        //new Solution10_1().findMin(new int[]{10,10,10,1,10});
        new Solution10_1().findMin(new int[]{2, 2, 2, 0, 1});
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
