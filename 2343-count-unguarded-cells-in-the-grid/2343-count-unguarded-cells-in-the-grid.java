class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // mark walls = -1, guards = 2
        for (int[] w : walls) grid[w[0]][w[1]] = -1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        // for each guard, mark visible cells in 4 directions
        for (int[] g : guards) {
            int x = g[0], y = g[1];
            
            // north
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == -1 || grid[i][y] == 2) break;
                grid[i][y] = 1;
            }

            // south
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == -1 || grid[i][y] == 2) break;
                grid[i][y] = 1;
            }

            // west
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == -1 || grid[x][j] == 2) break;
                grid[x][j] = 1;
            }

            // east
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == -1 || grid[x][j] == 2) break;
                grid[x][j] = 1;
            }
        }

        // count all unguarded = 0
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }

        return count;
    }
}
