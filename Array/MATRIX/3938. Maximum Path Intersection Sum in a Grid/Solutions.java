/*
| Approach                                                                                                                          | Time         | Space    |
| --------------------------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Apply Kadane’s algorithm separately on every row and column to find maximum contiguous sum, while also checking standalone cells. | **O(M · N)** | **O(1)** |

*/
class Solution {
    public int maxScore(int[][] grid) {
         int m = grid.length;
         int n=grid[0].length;
         int res=Integer.MIN_VALUE;
         //ROW SCANNING
         for(int i=0;i<m;i++){
            int sum=grid[i][0];
            for(int j=1;j<n;j++){
                res=Math.max(res,sum+grid[i][j]);
                sum=Math.max(grid[i][j],sum+grid[i][j]);
            }
         }
         //COL SCANNING
         for(int i=0;i<n;i++){
            int sum=grid[0][i];
            for(int j=1;j<m;j++){
                res=Math.max(res,sum+grid[j][i]);
                sum=Math.max(grid[j][i],sum+grid[j][i]);
            }
         }
         //checking standalone big number which can be bigger than res inside the matrix
         for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                res=Math.max(res,grid[i][j]);
            }
         }
         return res;
    }
}
