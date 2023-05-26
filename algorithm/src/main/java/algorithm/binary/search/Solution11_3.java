package algorithm.binary.search;

import java.util.HashSet;
import java.util.Set;

public class Solution11_3 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }


        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);

        int ansArray[] = new int[set1.size()];
        int k = 0;
        for (Integer one : set1) {
            ansArray[k++] = one;
        }
        return ansArray;

    }
}


