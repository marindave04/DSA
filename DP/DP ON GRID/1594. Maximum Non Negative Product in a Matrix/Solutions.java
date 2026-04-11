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
/*
| Approach                                      | Time Complexity | Space Complexity |
| --------------------------------------------- | --------------- | ---------------- |
| **BOTTOM-UP (Store max & min product at each cell)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int mod=1000000007;
    public int maxProductPath(int[][] grid) {
          int m=grid.length;
          int n=grid[0].length;
          Pair<Long,Long>[][] t=new Pair[m][n];
          t[0][0]=new Pair<>((long)grid[0][0],(long)grid[0][0]);
          for(int col=1;col<n;col++){
            t[0][col]=new Pair<>((long)grid[0][col]*t[0][col-1].getKey(),(long)grid[0][col]*t[0][col-1].getValue());
          }
          for(int row=1;row<m;row++){
            t[row][0]=new Pair<>((long)grid[row][0]*t[row-1][0].getKey(),(long)grid[row][0]*t[row-1][0].getValue());
          }
          for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long max=Long.MIN_VALUE;
                long min=Long.MAX_VALUE;
                long upmax=t[i-1][j].getKey();
                long leftmax=t[i][j-1].getKey();
                long upmin=t[i-1][j].getValue();
                long leftmin=t[i][j-1].getValue();
                 max=Math.max(max,Math.max(upmax*grid[i][j],upmin*grid[i][j]));
                 max=Math.max(max,Math.max(leftmax*grid[i][j],leftmin*grid[i][j]));
                 min=Math.min(min,Math.min(upmax*grid[i][j],upmin*grid[i][j]));
                 min=Math.min(min,Math.min(leftmax*grid[i][j],leftmin*grid[i][j]));
                 t[i][j]=new Pair<>(max,min);
            }
          }
          if(t[m-1][n-1].getKey()<0) return -1;
          return (int)((t[m-1][n-1].getKey())%mod);
    }
}
