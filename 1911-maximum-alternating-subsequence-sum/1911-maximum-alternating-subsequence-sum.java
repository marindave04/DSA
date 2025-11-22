class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] dp = new Long[nums.length][2];
       return (long)solve(nums,0,true,dp); 
    }
    static long solve(int[] nums,int idx,boolean flag,Long[][] dp){
        if(idx>=nums.length){
            return 0;
        }
         int f = flag ? 1 : 0;

        if (dp[idx][f] != null) return dp[idx][f];
        long skip=solve(nums,idx+1,flag,dp);
        long val=nums[idx];
        if(flag==false){
            val=-val;
        }
        long take=solve(nums,idx+1,!flag,dp)+val;
        return dp[idx][f]=(long)Math.max(skip,take);
    }
}