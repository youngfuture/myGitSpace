package main.java.algorithm.dynamic.programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathWithObstacles2 {

    List<List<Integer>> path = new LinkedList<>();  // 记录路径
    int r = 0;  // 行数
    int c = 0;  // 列数

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return path;
        }
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;

        if (obstacleGrid[r - 1][c - 1] == 1) {
            return path;
        }
        boolean[][] visit = new boolean[r][c];  // 记录数组
        backtrack(obstacleGrid, 0, 0, visit);
        return path;
    }

    public boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visit) {
        /**
         * 明确回溯法四要素：
         * 结束条件：走到右下角就结束；右下角本身有障碍物，不可能走得到；
         * 路径：走到当前位置之前已经走过的路径。
         * 选择：每次只能向下走或者向右走。当下方有障碍物时，只能考虑向右走；当右方有障碍物时，只能考虑向下走；当下方和右方都有障碍物时，只能往回走，你从哪个地方进入这个死胡同的就回到哪个地方去。
         * 约束条件：除了在“选择中的”约束之外，我们还不能走已经走过的地方。
         *
         */
        // 越界，有障碍，已访问
        if (x >= r || y >= c || obstacleGrid[x][y] == 1 || visit[x][y]) {
            return false;
        }

        // 如果不是以上情况，说明这个格子值得探索，做出选择
        path.add(Arrays.asList(x, y));


        visit[x][y] = true;

        // 选择后是否到达终点
        if (x == r - 1 && y == c - 1) {
            return true;
        }

        // 选择后没到终点，先尝试向下，再尝试向右，神奇的或运算
        if (backtrack(obstacleGrid, x + 1, y, visit) || backtrack(obstacleGrid, x, y + 1, visit)) {
            return true;
        }


        // 既不能向下也不能向右，是个死胡同，撤销选择
        path.remove(path.size() - 1);
        return false;

    }
}
