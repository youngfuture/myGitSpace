package main.java.algorithm.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/single-number/
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numTimes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numTimes.get(nums[i]) != null) {
                numTimes.put(nums[i], 2);
                numTimes.remove(nums[i]);
            } else {
                numTimes.put(nums[i], 1);
            }
        }

        return new ArrayList<>(numTimes.keySet()).get(0);
    }

    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}
