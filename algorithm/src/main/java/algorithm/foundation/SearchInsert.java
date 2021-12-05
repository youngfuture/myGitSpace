package algorithm.foundation;

public class SearchInsert {


    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int a = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                a = i;
                return a;
            } else if (target < nums[i]) {
                a = i;
                return a;
            }
        }
        return a;
    }

    int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
