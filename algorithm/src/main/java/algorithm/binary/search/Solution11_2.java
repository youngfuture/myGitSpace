package algorithm.binary.search;

import java.util.ArrayList;
import java.util.List;

public class Solution11_2 {

    public static void main(String[] args) {

        new Solution11_2().intersection(new int[]{3, 1, 2}, new int[]{1, 3});
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        List<Integer> ansList = new ArrayList<>();

        if (m > n) {
            for (int i = 0; i < n; i++) {
                if (ansList.contains(nums2[i])) {
                    continue;
                }

                if (search(nums1, nums2[i])) {
                    ansList.add(nums2[i]);
                }
            }

        } else {
            for (int i = 0; i < m; i++) {
                if (ansList.contains(nums1[i])) {
                    continue;
                }

                if (search(nums2, nums1[i])) {
                    ansList.add(nums1[i]);
                }
            }
        }

        int ansArray[] = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;

    }

    private boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
