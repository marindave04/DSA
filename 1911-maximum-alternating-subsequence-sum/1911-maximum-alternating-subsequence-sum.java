class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[][] dp = new long[n+1][2];
        for(int i=1;i<=n;i++){
            //even length
            dp[i][0]=(long)Math.max(dp[i-1][1]-nums[i-1],dp[i-1][0]);
            //odd length
             dp[i][1]=(long)Math.max(dp[i-1][0]+nums[i-1],dp[i-1][1]);
        }
        return (long)Math.max(dp[n][0],dp[n][1]);
    }
}