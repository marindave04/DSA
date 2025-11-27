class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    int a=dp[j];
                    int length=a+1;
                    dp[i]=Math.max(dp[i],length);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}