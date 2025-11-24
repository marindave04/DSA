class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][3];
       return solve(nums,0,0,dp);
    }
    static int solve(int[] nums,int i,int rem,int[][] dp){
        if(i>=nums.length){
            if(rem==0){
                return 0;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        if(dp[i][rem]!=0) return dp[i][rem];
        int take=nums[i]+solve(nums,i+1,(rem+nums[i])%3,dp);
        int skip=solve(nums,i+1,rem,dp);
        return dp[i][rem]=Math.max(take,skip);
    }
}