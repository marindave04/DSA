/*
| Approach                                                   | Time Complexity | Space Complexity |
| ---------------------------------------------------------- | --------------- | ---------------- |
| **DFS from Boundary (Remove Reachable Land / Flood Fill)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int m;
    static int n;
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int numEnclaves(int[][] grid) {
         m=grid.length;
         n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && (grid[i][j]==1) && (!visited[i][j] )){
                    dfs(grid,i,j,visited);
                }
            }
        }
        int count=0;
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    static void dfs(int[][] grid,int r,int c,boolean[][] visited){
        visited[r][c]=true;
        grid[r][c]=0;
        for(int[] dir:directions){
             int new_i=r+dir[0];
              int new_j=c+dir[1];
                   
             if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && grid[new_i][new_j]==1 && !visited[new_i][new_j]){
             
              dfs(grid,new_i,new_j,visited);
             }
        }
    }
}
