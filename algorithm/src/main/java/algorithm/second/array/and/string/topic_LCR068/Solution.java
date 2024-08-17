package algorithm.second.array.and.string.topic_LCR068;

/**
 *
 * LCR 068. 搜索插入位置
 *
 *
 * 考虑这个插入的位置 pos，它成立的条件为:
 * nnums[pos−1]<target≤nums[pos]
 *
 * 其中 nums代表排序数组。由于如果存在这个目标值，我们返回的索引也是 pos,因此我们可以将两个条件合并得出最后的目标：
 * 「在一个有序数组中找第一个大于等于 target的下标」。
 *
 * 问题转化到这里，直接套用二分法即可，即不断用二分法逼近查找第一个大于等于 target的下标 。
 * 下文给出的代码是笔者习惯的二分写法，ans初值设置为数组长度可以省略边界条件的判断，
 * 因为存在一种情况是 target大于数组中的所有数，此时需要插入到数组长度的位置。

 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n - 1, ans = n;

        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}