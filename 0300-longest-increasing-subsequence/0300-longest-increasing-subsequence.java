class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][n+1];
        
  for (int i = 0; i < n; i++) {
    Arrays.fill(dp[i], -1);
    }
        return solve(nums,0,-1,dp);
    }
    static int solve(int[] nums,int i,int pre,int[][]dp){
        if(i>=nums.length){
            return 0;
        }
        if( dp[i][pre+1]!=-1) return dp[i][pre+1];
        int skip=solve(nums,i+1,pre,dp);
         int take=0;
        if(pre==-1 || nums[i]>nums[pre]){
            take=1+solve(nums,i+1,i,dp);
        }
       
        return  dp[i][pre+1]=(int)Math.max(skip,take);
    }
}