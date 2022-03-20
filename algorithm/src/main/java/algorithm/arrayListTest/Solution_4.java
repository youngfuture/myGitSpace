package algorithm.arrayListTest;

public class Solution_4 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2&&nums[1] == nums[0]) {
            return 1;
        }

        int i = 1;
        int j = 0;
        while (true && i < nums.length && j < nums.length) {
            while (nums[i] == nums[j] && i < nums.length) {
                i++;
                if (nums[i] == nums[j] && i == nums.length - 1) {
                    return j + 1;
                }
            }
            j++;
            nums[j] = nums[i];
            if (i == nums.length - 1) {
                break;
            }
        }
        return j + 1;
    }
}
