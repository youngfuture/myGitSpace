package algorithm.queueAndStack;

class Solution1 {

    /*
     * 首先访问当前顶点
     * 然后dfs访问当前顶点的，上下左右4个邻接点
     * 然后再sdf访问上下左右
     * 遇到边界退出，数组越界算边界，访问过==0 算边界
     *
     * 这里的每个节点固定只有上下左右4个邻接点，真实的图中一个顶点S可以有N个邻接点，当前场景算一种实例
     *
     */
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        //访问过的节点置为 0
        grid[r][c] = '0';

        //上下左右的顺序访问节点，每个顶点都有上下左右4个邻接点，
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    //对每个节点进行深度搜索遍历，一次深度遍历表示一个连通分量
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}