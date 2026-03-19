/*
| Approach                                                            | Time Complexity | Space Complexity |
| ------------------------------------------------------------------- | --------------- | ---------------- |
| **Brute Force (Compute sum of each submatrix from (0,0) to (i,j))** | **O(m² · n²)**  | **O(1)**         |

*/
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int count=0;
        for(int i=0;i<m;i++){
            int n=grid[i].length;
            for(int j=0;j<n;j++){
                //tracking submatrices from from(0,0) to (i,j)
                int sum=0;
                for(int x=0;x<=i;x++){
                   
                    for(int y=0;y<=j;y++){
                        sum+=grid[x][y];
                    }
                }
                if(sum<=k) count++;
            }
        }
        return count;
    }
}
/*
| Approach                                                                       | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------ | --------------- | ---------------- |
| **2D Prefix Sum (Row-wise + Accumulated column sum for submatrix from (0,0))** | **O(m · n)**    | **O(m · n)**     |

*/
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] psum1=new int[m][n];
         int[][] psum2=new int[m][n];
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum=grid[i][j]+(j>0 ? psum1[i][j-1] : 0);
                psum1[i][j]=sum;
                if(i>0){
                    sum+=psum2[i-1][j];
                }
                psum2[i][j]=sum;
                if(sum<=k) count++;
            }
        }
        return count;
    }
}
/*
| Approach                                                                              | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Optimized 2D Prefix Sum (In-place row prefix + 1D buffer for column accumulation)** | **O(m · n)**    | **O(n)**         |

*/
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] psum1=new int[m][n];
         int[][] psum2=new int[m][n];
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum=grid[i][j]+(j>0 ? psum1[i][j-1] : 0);
                psum1[i][j]=sum;
                if(i>0){
                    sum+=psum2[i-1][j];
                }
                psum2[i][j]=sum;
                if(sum<=k) count++;
            }
        }
        return count;
    }
}
