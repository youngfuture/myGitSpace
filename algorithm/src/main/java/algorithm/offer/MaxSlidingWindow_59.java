package main.java.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class MaxSlidingWindow_59 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 1) {
            return nums;
        }

        int start = 0;
        int end = start + k - 1;

        //[7,2,4]
        //2
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (; start < nums.length && end < nums.length; ) {
            int currentMax = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (nums[i] > currentMax) {
                    currentMax = nums[i];
                }
            }
            result.add(currentMax);

            start++;
            end = start + k - 1;
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return nums;
        }
        //#1
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            //#2
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);

            //#3
            if (queue.peekFirst() <= (i - k)) {//如果被窗口抛下了（在窗口左边界的左侧）
                queue.pollFirst();
            }
            if (i >= k - 1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }


}
