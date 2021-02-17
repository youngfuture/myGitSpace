package main.java.algorithm.dynamic.programming;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        //假设最优解的最后一枚银币是ak，则前面k-1枚银币的的和= amount - ak
        //原问题：求凑成总金额amount所需的最少的硬币个数k等于多少？
        //子问题：求凑成总金额amount - ak所需的最少的硬币个数k-1等于多少？
        //1.确定状态组数：f[i] ,i表示目标金额；f[i]表示最少的硬币个数
        //2.转移方程：f[amount]= min{f[amount - coins[0]]+1,f[amount - coins[2]]+1,.....}
        //3.初始条件：f[-n]= Integer.max,f[0]=0;
        //4.从小到大计算

        int[] f = new int[amount + 1];

        f[0] = 0;

        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Integer.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }

        if(f[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return f[amount];
    }
}
