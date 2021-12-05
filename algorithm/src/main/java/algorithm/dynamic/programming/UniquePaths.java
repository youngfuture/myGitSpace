package algorithm.dynamic.programming;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //有多少条不同的路径走到 f[m][n]=f[m-1][n]+f[m][n-1]
        //子问题：有多少条不同的路径 f[m-1][n] 或  f[m][n-1]

        int i;
        int j;
        int[][] f = new int[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }

        }
        return f[m - 1][n - 1];
    }
}
