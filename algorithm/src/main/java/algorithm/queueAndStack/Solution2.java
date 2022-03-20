package algorithm.queueAndStack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        //两层循环遍历所有节点
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '0') {
                    continue;
                }

                //开始一次广度优先搜索遍历，次变量记录搜索的次数
                ++num_islands;

                //访问过的节点置为 0
                grid[r][c] = '0';

                //邻接点队列
                Queue<Integer> neighbors = new ArrayDeque<>();

                //假设所有元素排一个序号，按照从上到下，从左到右排
                //把当前节点入队，r * nc + c = 当前节点排列后的序号
                neighbors.add(r * nc + c);


                //广度优先遍历类似层序遍历，对当前顶点及顶点的所有邻接点访问一次类似访问一层，一层的所有顶点放到一个队列中
                while (!neighbors.isEmpty()) {
                    int id = neighbors.remove();

                    //根据入队元素的序号反算出坐标系数
                    int row = id / nc;
                    int col = id % nc;

                    //当前顶点的上一个顶点，如果此顶点满足==1，表示是当前顶点的邻接点；把上邻接点入队且标记为已访问过
                    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                        neighbors.add((row - 1) * nc + col);
                        grid[row - 1][col] = '0';
                    }

                    //下一个邻接点
                    if (row + 1 < nr && grid[row + 1][col] == '1') {
                        neighbors.add((row + 1) * nc + col);
                        grid[row + 1][col] = '0';
                    }

                    //左一个邻接点
                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        neighbors.add(row * nc + col - 1);
                        grid[row][col - 1] = '0';
                    }

                    //右一个邻接点
                    if (col + 1 < nc && grid[row][col + 1] == '1') {
                        neighbors.add(row * nc + col + 1);
                        grid[row][col + 1] = '0';
                    }
                }

            }
        }

        return num_islands;
    }
}
