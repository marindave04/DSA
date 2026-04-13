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
/*
| Approach                                                        | Time Complexity  | Space Complexity |
| --------------------------------------------------------------- | ---------------- | ---------------- |
| **Bottom-Up 3D DP (Tabulation with Power State for Negatives)** | **O(m × n × 3)** | **O(m × n × 3)** |

*/
//Wrirting Bottom-up in reverse 
class Solution {
    public int maximumAmount(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;   
       int[][][] t=new int[m][n][3];
       //filling last cell means the base case of recursion+memoization
       for(int power=0;power<=2;power++){
        if(grid[m-1][n-1]>=0){
            t[m-1][n-1][power]=grid[m-1][n-1];
        }else{
            if(power>0) t[m-1][n-1][power]=0;
            else t[m-1][n-1][power]=grid[m-1][n-1];
        }
       }
       //filling the remaining celss as we go from right bottom cell to left top cell
       for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(i==m-1 && j==n-1) continue;//bacause it is last cell
            for(int power=0;power<=2;power++){
                int right=Integer.MIN_VALUE;
                int down=Integer.MIN_VALUE;
                //going right
                if(j+1<n){
                    if(grid[i][j]>=0){
                         right=grid[i][j]+t[i][j+1][power];
                    }else{
                        if(power>0){
                            right=Math.max(t[i][j+1][power-1],grid[i][j]+t[i][j+1][power]);
                        }else{
                             right=grid[i][j]+t[i][j+1][power];
                        }
                    }
                }
                //going down
                 if(i+1<m){
                    if(grid[i][j]>=0){
                         down=grid[i][j]+t[i+1][j][power];
                    }else{
                        if(power>0){
                            down=Math.max(t[i+1][j][power-1],grid[i][j]+t[i+1][j][power]);
                        }else{
                             down=grid[i][j]+t[i+1][j][power];
                        }
                    }
                }
                t[i][j][power]=Math.max(right,down);
            }
        }
       }
       return t[0][0][2];
    }
}
