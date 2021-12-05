package algorithm.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    static List<List<Integer>> result;

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        new CombinationSum_39().combinationSum(candidates, target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, new ArrayList<>(), 0);

        return result;


    }

    private void backtrack(int[] candidates, int remains, List<Integer> path, int start) {
        if (remains == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remains)
                return;

            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            //[2,2,3,5]

            path.add(candidates[i]);

            backtrack(candidates, remains - candidates[i], path, i);

            path.remove(path.size() - 1);
        }
    }
}
