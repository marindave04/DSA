class Solution {

    int ROW;
    int COL;

    // directions: down, up, right, left
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // DFS function
    boolean dfs(int[][] grid, int i, int j) {

        // boundary check + blocked cell check
        if (i < 0 || i >= ROW || j < 0 || j >= COL || grid[i][j] == 1) {
            return false;
        }

        // reached bottom row
        if (i == ROW - 1) {
            return true;
        }

        // mark visited
        grid[i][j] = 1;

        // explore all 4 directions
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (dfs(grid, new_i, new_j)) {
                return true;
            }
        }

        return false;
    }

    // check if crossing is possible till "day"
    boolean canCross(int[][] cells, int day) {

        int[][] grid = new int[ROW][COL];

        // mark flooded cells till given day
        for (int i = 0; i <= day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        // try DFS from every column in top row
        for (int j = 0; j < COL; j++) {
            if (grid[0][j] == 0 && dfs(grid, 0, j)) {
                return true;
            }
        }

        return false;
    }

    // main function
    public int latestDayToCross(int row, int col, int[][] cells) {

        ROW = row;
        COL = col;

        int l = 0;
        int r = cells.length - 1;
        int lastDay = 0;

        // binary search on days
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (canCross(cells, mid)) {
                lastDay = mid + 1; // +1 because day is 1-indexed
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return lastDay;
    }
}
