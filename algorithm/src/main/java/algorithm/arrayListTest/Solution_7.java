package algorithm.arrayListTest;

public class Solution_7 {

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int currentAns = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(currentAns, ans);

            if (height[left] <= height[right]) {  // 移动较小的那一端
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
