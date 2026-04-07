/*
| Approach                                           | Time Complexity | Space Complexity |
| -------------------------------------------------- | --------------- | ---------------- |
| **Top-Down DP (DFS + Memoization with Obstacles)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int[][] t=new int[101][101];
    public int uniquePathsWithObstacles(int[][] grid) {
        for(int[] row:t){
            Arrays.fill(row,-1);
        }
         return solve(grid,0,0);
    }
    static int solve(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==1) return 0;
        if(i==grid.length-1 && j==grid[0].length-1 ) return 1;
        if(t[i][j]!=-1) return t[i][j];
        int right=solve(grid,i,j+1);
        int down=solve(grid,i+1,j);
        return t[i][j]=right+down;
    }
}
/*
| Approach                                              | Time Complexity | Space Complexity |
| ----------------------------------------------------- | --------------- | ---------------- |
| **Bottom-Up DP (Tabulation with Obstacles Handling)** | **O(m × n)**    | **O(m × n)**     |
*/
class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       if(grid[0][0]==1) return 0;
       int[][] t=new int[m][n];
       t[0][0]=1;
       for(int col=1;col<n;col++){
        if(grid[0][col]==1){
            for(int j=col;j<n;j++){
                t[0][j]=0;
            }
            break;
        }
        t[0][col]=1;
      }
      for(int row=1;row<m;row++){
        if(grid[row][0]==1){
            for(int i=row;i<m;i++){
                t[i][0]=0;
            }
            break;
        }
        t[row][0]=1;
      }
       for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            if(grid[i][j]==1) t[i][j]=0;
             else t[i][j]=t[i-1][j]+t[i][j-1];
        }
      }
      return t[m-1][n-1];
    }
}
