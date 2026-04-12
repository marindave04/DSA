/*
| Approach                                                     | Time Complexity  | Space Complexity |
| ------------------------------------------------------------ | ---------------- | ---------------- |
| **3D DP (DFS(TOP-DOWN)+ Memoization with Power State for Negatives)** | **O(m × n × 3)** | **O(m × n × 3)** |

*/
class Solution {
    static int m;
    static int n;
    static int[][][] t=new int[501][501][3];
    public int maximumAmount(int[][] coins) {
        for(int i=0;i<501;i++){
            for(int j=0;j<501;j++){
                for(int k=0;k<3;k++){
                    t[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        m=coins.length;
        n=coins[0].length;
        return solve(coins,0,0,2);
    }
    static int solve(int[][] grid,int i,int j,int power){
        if(i==m-1 && j==n-1){
            if(grid[i][j]>=0){
                return grid[i][j];
            }else if(grid[i][j]<0){
                if(power>0) return 0;
                else return grid[i][j];
            }
            return 0;
        }
        if(t[i][j][power]!=Integer.MIN_VALUE) return t[i][j][power];
        int right=Integer.MIN_VALUE;
        int down=Integer.MIN_VALUE;
        if(i==m-1){
            if(grid[i][j]>=0){
                right=grid[i][j]+solve(grid,i,j+1,power);
            }else{
                if(power>0){
                     right=Math.max(solve(grid,i,j+1,power-1),grid[i][j]+solve(grid,i,j+1,power));
                    
                }else{
                    right=grid[i][j]+solve(grid,i,j+1,power);
                }
            }
        }else if(j==n-1){
            if(grid[i][j]>=0){
                
                down=grid[i][j]+solve(grid,i+1,j,power);
            }else{
                if(power>0){
                      
                     down=Math.max(solve(grid,i+1,j,power-1),grid[i][j]+solve(grid,i+1,j,power));
                     
                }else{
                    
                    down=grid[i][j]+solve(grid,i+1,j,power);
                }
            }
        }else{
           if(grid[i][j]>=0){
                right=grid[i][j]+solve(grid,i,j+1,power);
                down=grid[i][j]+solve(grid,i+1,j,power);
            }else{
                if(power>0){
                      right=Math.max(solve(grid,i,j+1,power-1),grid[i][j]+solve(grid,i,j+1,power));
                      down=Math.max(solve(grid,i+1,j,power-1),grid[i][j]+solve(grid,i+1,j,power));
                }else{
                     right=grid[i][j]+solve(grid,i,j+1,power);
                    down=grid[i][j]+solve(grid,i+1,j,power);
                }
            }
        }
        return t[i][j][power]=Math.max(right,down);
    }
}
