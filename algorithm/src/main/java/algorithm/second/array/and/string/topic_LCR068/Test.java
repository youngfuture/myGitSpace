package algorithm.second.array.and.string.topic_LCR068;

public class Test {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(nums[l] == target){
            return l;
        }
        return -1;
    }

}
