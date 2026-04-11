/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **TOP DOWN + Memoization (Track Max & Min Product per Cell)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int mod=1000000007;
    static int m;
    static int n;
    //Memoize
    static Pair<Long,Long>[][] t;  
    public int maxProductPath(int[][] grid) {
          m=grid.length;
          n=grid[0].length;
          t=new Pair[m][n];
          Pair<Long,Long> ans=solve(grid,0,0);
          return ans.getKey()<0 ? -1: (int)(ans.getKey()%mod);
    }
    static Pair<Long,Long> solve(int[][] grid,int i,int j){
        if(i==m-1 && j==n-1){
            return new Pair<>((long)grid[i][j],(long)grid[i][j]);
        }
        if(t[i][j]!=null) return t[i][j];
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        //DOWN
        if(i+1<m){
            Pair<Long,Long> down=solve(grid,i+1,j);
            max=Math.max(max,Math.max(grid[i][j]*down.getKey(),grid[i][j]*down.getValue()));
            min=Math.min(min,Math.min(grid[i][j]*down.getKey(),grid[i][j]*down.getValue()));
        }
        //RIGHT
        if(j+1<n){
            Pair<Long,Long> right=solve(grid,i,j+1);
            max=Math.max(max,Math.max(grid[i][j]*right.getKey(),grid[i][j]*right.getValue()));
            min=Math.min(min,Math.min(grid[i][j]*right.getKey(),grid[i][j]*right.getValue()));
        }
        t[i][j]=new Pair<>(max,min);
         return t[i][j];
    }
}
