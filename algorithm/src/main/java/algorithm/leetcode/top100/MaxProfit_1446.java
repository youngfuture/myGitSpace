package algorithm.leetcode.top100;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit_1446 {
    public static void main(String[] args) {
        System.out.println(new MaxProfit_1446().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        // dp[i][j] 表示第i 天买入 第j 天卖出的利润
        // dp[i][j] = max{ prices[j]-prices[i],,,,} j>i

        //[7,1,5,3,6,4]
        int i = 0;
        int j = 0;
        for (; i < prices.length && i + 1 < prices.length; i++) {
            for (j = i + 1; j < prices.length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (prices[j] - prices[i] > 0) {
                    dp[i][j] = Integer.max(dp[i][j], prices[j] - prices[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < prices.length; k++) {
            for (int m = 0; m < prices.length; m++) {
                max = Integer.max(dp[k][m], max);
            }
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        //[7,1,5,3,6,4]
        int i = 0;
        int j = 0;
        int maxResult = 0;
        for (; i < prices.length && i + 1 < prices.length; i++) {
            for (j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > 0) {
                    maxResult = Integer.max(maxResult, prices[j] - prices[i]);
                }
            }
        }

        return maxResult;
    }


    //[7,1,5,3,6,4]
    //假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1] 之间选最低点买入；所以遍历数组，依次求每个卖出时机的的最大差值，再从中取最大值
    //最低点前面不可能卖，且不能出现这种情况，所以只有最低点后面卖才可能最大差
    public int maxProfit3(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxProfit) {
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }
}
