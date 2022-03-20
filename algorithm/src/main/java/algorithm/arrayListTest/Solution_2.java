package algorithm.arrayListTest;

public class Solution_2 {


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        new Solution_2().removeElement(nums,2);
        System.out.println(nums);
    }

    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                //i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }

        for(int m=0;m<nums.length;m++){
            if(nums[m]==val){
                return m+1;
            }
        }
        return nums.length;

    }
    //[0,1,2,2,3,0,4,2]
    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
