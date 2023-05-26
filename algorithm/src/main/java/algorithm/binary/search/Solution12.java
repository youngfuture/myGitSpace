package algorithm.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution12 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> statMap1 = new HashMap<>();
        Map<Integer, Integer> statMap2 = new HashMap<>();
        int m = nums1.length, n = nums2.length;

        for (int i = 0; i < m; i++) {
            if (statMap1.get(nums1[i]) == null) {
                statMap1.put(nums1[i], 1);
            } else {
                statMap1.put(nums1[i], statMap1.get(nums1[i]) + 1);
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
        for (Map.Entry<Integer, Integer> entry2 : statMap2.entrySet()) {
            if (statMap1.get(entry2.getKey()) != null) {
                if (statMap1.get(entry2.getKey()) > entry2.getValue()) {
                    for (int i = 0; i < entry2.getValue(); i++) {
                        ansList.add(entry2.getKey());
                    }
                } else {
                    for (int i = 0; i < statMap1.get(entry2.getKey()); i++) {
                        ansList.add(entry2.getKey());
                    }
                }
            }
        }

        int[] ansArray = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;
    }
}
