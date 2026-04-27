/*
| Approach                                                                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| DFS from `(0,0)`, move only through allowed street directions, and verify neighbor has reverse connection before continuing | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int m;
    static int n;
    static int[][][] directions={
        {},
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited=new boolean[m][n];
        return dfs(grid,0,0,visited);
    }
    static boolean dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i==m-1 && j==n-1) return true;
        visited[i][j]=true;
        for(int[] dir:directions[grid[i][j]]){
            int ni=i+dir[0];
            int nj=j+dir[1];
            if(ni>=0 && ni<m && nj>=0 && nj<n && !visited[ni][nj]){
                boolean connected=false;
                for(int[] p:directions[grid[ni][nj]]){
                    if(ni+p[0]==i && nj+p[1]==j){
                        connected=true;
                        break;
                    }
                }
                if(!connected) continue;
                if(dfs(grid,ni,nj,visited)) return true;
            }
        }
        return false;
    }
}
