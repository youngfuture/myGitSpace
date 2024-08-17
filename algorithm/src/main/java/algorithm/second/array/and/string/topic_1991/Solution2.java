package algorithm.second.array.and.string.topic_1991;

/**
 * link{https://leetcode.cn/problems/find-the-middle-index-in-array/solutions/988569/1991zhao-dao-shu-zu-de-zhong-jian-wei-zh-e8cp/}
 * 其实本题考查的是前缀和，而下面的三种解法都是使用前缀和来解答问题。
 */
public class Solution2 {

    public int findMiddleIndex(int[] nums) {

        for(int i = 0;i < nums.length; i++) {
            int sumLeft = sumLeft(i,nums);
            int sumRight = sumRight(i,nums);
            if(sumLeft==sumRight){
                return i;
            }
        }
        return -1;

    }

    private int sumLeft(int i, int[] nums) {
        int sumLeft = 0;
        for(int j=0;j<i;j++){
            sumLeft += nums[j];
        }
        return  sumLeft;
    }

    private int sumRight(int i,int [] nums){
        int sumRight=0;
        for(int k=nums.length-1;k>i;k--){
            sumRight +=nums[k];
        }
        return sumRight;
    }
}
