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
    int solve(int[] nums,int s,int e,int[]dp){
       int len=(e-s)+1;
       dp[0]=0;
       dp[1]=nums[s];
       int idx=2;
       for(int i=idx;i<=len;i++){
       int pick=nums[idx-1+s]+dp[idx-2];
       int notPick=dp[idx-1];
       dp[idx]=(int) Math.max(pick,notPick);
       idx++;
       }
      return dp[len]; 
    }
}