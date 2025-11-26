class Solution {
     static int mod = 1000000007;
     static Integer[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new Integer[m][n][k];
        return solve(grid,0,0,0,k);
    }
    static int solve(int[][] grid,int i,int j,int sum,int k){
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            if((sum+grid[i][j])%k==0) {
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][j][sum]!=null) return dp[i][j][sum];
        int right=solve(grid,i,j+1,(sum+grid[i][j])%k,k);
        int down=solve(grid,i+1,j,(sum+grid[i][j])%k,k);
        return dp[i][j][sum]=(right+down)%mod;
    }
}