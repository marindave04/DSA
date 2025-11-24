class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
       int[][] dp=new int[n+1][3];
       dp[n][0]=0;
       dp[n][1]=Integer.MIN_VALUE;
       dp[n][2]=Integer.MIN_VALUE;
       for(int i=n-1;i>=0;i--){
        for(int r=0;r<=2;r++){
            int newR=(r+nums[i])%3;
            int take=nums[i]+dp[i+1][newR];
            int skip=dp[i+1][r];
            dp[i][r]=Math.max(take,skip);
        }
       }
       return dp[0][0];
    }
}