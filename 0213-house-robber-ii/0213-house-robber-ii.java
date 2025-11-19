class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1=new int[1000+1];
        int[] dp2=new int[1000+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int n=nums.length;
        int a=solve(nums,0,n-2,dp1);
        int b=solve(nums,1,n-1,dp2);
        return (int)Math.max(a,b);
    }
    static int solve(int[] nums,int s,int e,int[]dp){
        if(s>e) return 0;
        if(dp[s]!=-1) return dp[s];
        int notSkip=nums[s]+solve(nums,s+2,e,dp);
        int skip=solve(nums,s+1,e,dp);
        return dp[s]=(int)Math.max(notSkip,skip);
    }
}