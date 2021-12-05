package algorithm.offer;

public class MissingNumber_53 {

    //输入: [0,1,2,3,4,5,6,7,9]
    //输出: 8


    //输入: [0,1]
    //输出: 2

    //输入: [0]
    //输出: 1

    //输入: [1]
    //输出: 0
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 0;
            }
            if (nums[0] == 0) {
                return 1;
            }
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i + 1;
    }
}
