package algorithm.arrayListTest;

public class Solution_1 {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        new Solution_1().removeElement(nums, 3);
        System.out.println(nums);
    }
    
    public int removeElement(int[] nums, int val) {

        if (nums.length == 1) {
            if (nums[0] == val) {
                nums[0] = 0;
                return 0;
            }
            if (nums[0] != val) {
                return 1;
            }
        }

        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=val，就把其交换到左边，等于val的交换到右边
            if (nums[i] != val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }

        int result = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == val) {
                nums[k] = 0;
                result++;
            }
        }
        return nums.length - result;
    }

}