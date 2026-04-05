/*
| Approach                            | Time Complexity | Space Complexity |
| ----------------------------------- | --------------- | ---------------- |
| **Top-Down DP (DFS + Memoization)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int[][] t=new int[101][101];
    public int uniquePaths(int m, int n) {
        for(int[] row:t){
            Arrays.fill(row,-1);
        }
        return solve(0,0,m,n);
    }
    static int solve(int i,int j,int m,int n){
        if(i==m-1 && j==n-1) return 1;
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int right=solve(i,j+1,m,n);
        int down=solve(i+1,j,m,n);
        return t[i][j]=right+down;
    }
}
