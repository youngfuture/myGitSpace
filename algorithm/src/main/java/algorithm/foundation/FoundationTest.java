
package algorithm.foundation;

import java.util.Arrays;

public class FoundationTest {

    public static void main(String[] args) {
        int[] s1 = new int[]{1, 7, 3, 6, 5, 6};
        int[] s2 = new int[]{1, 2, 3};
        int[] s3 = new int[]{2, 1, -1};
        int[] s4 = new int[]{-1, -1, -1, -1, -1, -1};
        int[] s5 = new int[]{-1, -1, -1, -1, -1, 0};
        int[] s6 = new int[]{-1, 2, 4,6, 1, -1, 1};
//
//        System.out.println(new FoundationTest().pivotIndex(s1));
//        System.out.println(new FoundationTest().pivotIndex(s2));
//        System.out.println(new FoundationTest().pivotIndex(s3));
//        System.out.println(new FoundationTest().pivotIndex(s4));
//        System.out.println(new FoundationTest().pivotIndex(s5));
        System.out.println(new FoundationTest().pivotIndex(s6));
    }

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            //求出数据
            sum += nums[i];
        }
        if (sum - nums[0] == 0) return 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += nums[i];
            if (i == len - 1) return -1;
            if (temp * 2 == sum - nums[i + 1])
                return i + 1;
        }
        return -1;
    }
}
