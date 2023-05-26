package algorithm.binary.search;

import java.util.*;

public class Solution11 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> statMap = new HashMap<>();
        Map<Integer, Integer> statMap2 = new HashMap<>();
        int m = nums1.length, n = nums2.length;

        for (int i = 0; i < m; i++) {
            if (statMap.get(nums1[i]) == null) {
                statMap.put(nums1[i], 1);
            } else {
                statMap.put(nums1[i], statMap.get(nums1[i]) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (statMap2.get(nums2[i]) == null) {
                statMap2.put(nums2[i], 1);
            } else {
                statMap2.put(nums2[i], statMap2.get(nums2[i]) + 1);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : statMap2.entrySet()) {
            if(statMap.get(entry.getKey())!=null){
                ansList.add(entry.getKey());
            }
        }

        int[] ansArray = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;
    }
}
