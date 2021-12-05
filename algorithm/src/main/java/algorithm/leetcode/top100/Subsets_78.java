package algorithm.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public static void main(String[] args) {
        new Subsets_78().subsets(new int[]{3, 2, 7, 4});
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();

            for (List<Integer> subset : result) {
                List<Integer> current = new ArrayList<>(subset);
                current.add(nums[i]);
                newSubsets.add(current);
            }
            result.addAll(newSubsets);
        }
        return result;

    }
}
