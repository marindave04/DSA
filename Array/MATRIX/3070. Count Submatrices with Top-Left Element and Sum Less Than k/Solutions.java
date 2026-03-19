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
