package algorithm.binary.search;

public class Solution14 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        //这里的left、right 既可以表示是重复元素的值空间的值，也可以表示是下标，因为题目给出的一共n+1个元素，元素大小 1-n，这个要想明白
        //因为有一个元素重复，则最大元素肯定是长度-1，即是 right = n - 1 ，这个也要想明白，不然会感觉值和索引下标错乱
        int left = 1, right = n - 1, ans = -1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int count = 0;

            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
