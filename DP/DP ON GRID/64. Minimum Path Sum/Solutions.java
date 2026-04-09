/*
| Approach                            | Time Complexity | Space Complexity |
| ----------------------------------- | --------------- | ---------------- |
| **DFS + Memoization (Top-Down DP)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int m;
    static int n;
    static int[][] t=new int[201][201];
    public int minPathSum(int[][] grid) {
        for(int[] row:t){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        m=grid.length;
        n=grid[0].length;
        return solve(grid,0,0);
    }
    static int solve(int[][] grid,int i,int j){
       if(i==m-1 && j==n-1) return grid[i][j];
       if(t[i][j]!=Integer.MAX_VALUE) return t[i][j];
       int right=Integer.MAX_VALUE;
       int down=Integer.MAX_VALUE;
       if(i==m-1){
          right=grid[i][j]+solve(grid,i,j+1);
       }else if(j==n-1){
          down=grid[i][j]+solve(grid,i+1,j);
       }else{
         right=grid[i][j]+solve(grid,i,j+1);
         down=grid[i][j]+solve(grid,i+1,j);
       }
       return t[i][j]=Math.min(right,down);
    }
}
/*
| Approach                      | Time Complexity | Space Complexity |
| ----------------------------- | --------------- | ---------------- |
| **Bottom-Up DP (Tabulation)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    public int minPathSum(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int[][] t=new int[m][n];
       t[0][0]=grid[0][0];
       for(int col=1;col<n;col++){
        t[0][col]=t[0][col-1]+grid[0][col];
       }
       for(int row=1;row<m;row++){
        t[row][0]=t[row-1][0]+grid[row][0];
       }
       for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            t[i][j]=grid[i][j]+Math.min(t[i-1][j],t[i][j-1]);
        }
       }
       return t[m-1][n-1];
    }
}
