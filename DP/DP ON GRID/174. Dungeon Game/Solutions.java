/*
| Approach                                            | Time Complexity           | Space Complexity |
| --------------------------------------------------- | ------------------------- | ---------------- |
| **Binary Search + DFS (with Memoization on State)** | **O(log(MaxHP) × m × n)** | **O(m × n)**     |

*/
class Solution {
    static int m;
    static int n;
    static HashMap<String,Boolean> t=new HashMap<>();
    public int calculateMinimumHP(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int l=1;
        int r=(int)4*(int)1e7;
        int ans=(int)4*(int)1e7;
        while(l<=r){
            int mid=l+(r-l)/2;
            t.clear();
            if(solve(grid,mid,0,0)){
               ans=mid;
               r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean solve(int[][] grid,int mid,int i,int j){
       if(i>=m || j>=n) return false;
       mid+=grid[i][j];
       if(mid<=0) return false;
       if(i==m-1 && j==n-1) return true;
       String key=i+"-"+j+"-"+mid;
       if(t.containsKey(key)) return t.get(key);
       boolean temp=solve(grid,mid,i,j+1) || solve(grid,mid,i+1,j);
       t.put(key,temp);
       return temp;
    }
}
/*
| Approach                                          | Time Complexity | Space Complexity |
| ------------------------------------------------- | --------------- | ---------------- |
| **DFS + Memoization (Minimum Initial Health DP)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int m;
    static int n;
    static int[][] t=new int[201][201];
    public int calculateMinimumHP(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        for(int[] row:t){
            Arrays.fill(row,-1);
        }
        return solve(grid,0,0);
    }
    static int solve(int[][] grid,int i,int j){
        if(i==m-1 && j==n-1){
            if(grid[i][j]<=0){
                return Math.abs(grid[i][j])+1;
            }
            return 1;
        }
        if(t[i][j]!=-1) return t[i][j];
        int right=Integer.MAX_VALUE;
        int down=Integer.MAX_VALUE;
        if(i==m-1){
            right=solve(grid,i,j+1);
        }else if(j==n-1){
            down=solve(grid,i+1,j);
        }else{
            right=solve(grid,i,j+1);
            down=solve(grid,i+1,j);
        }
        int result=Math.min(right,down)-grid[i][j];
        return t[i][j]=result<=0 ? 1 : result;
    }
}
/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **Bottom-Up DP (Tabulation for Minimum Initial Health)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] t=new int[m][n];
        if(grid[m-1][n-1]<=0){
            t[m-1][n-1]=Math.abs(grid[m-1][n-1])+1;
        }else{
            t[m-1][n-1]=1;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int right=Integer.MAX_VALUE;
                int down=Integer.MAX_VALUE;
                if(i==m-1 && j==n-1) continue;
                //right
                if(j+1<n){
                    right=t[i][j+1];
                }
                //down
                if(i+1<m){
                    down=t[i+1][j];
                }
                int result=Math.min(right,down)-grid[i][j];
                t[i][j]=result<=0 ? 1 : result;
            }
        }
        return t[0][0];
    }
}
