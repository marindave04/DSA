class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] dp=new Long[nums.length][2];
       return solve(nums,0,true,dp);
    }
    static long solve(int[] nums,int i,boolean flag,Long[][]dp){
        if(i>=nums.length) return 0;
        int f=flag ? 1:0;
        if(dp[i][f]!=null) return dp[i][f];
        long val=0;
        if(flag){
            val=nums[i];
        }else{
            val=-nums[i];
        }
        long take=val+solve(nums,i+1,!flag,dp);
        long skip=solve(nums,i+1,flag,dp);
        return dp[i][f]=(long)Math.max(take,skip);
    }
}