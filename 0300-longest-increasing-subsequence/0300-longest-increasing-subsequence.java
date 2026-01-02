class Solution {
   public int lengthOfLIS(int[] nums) {
    int n=nums.length;
    int[] t=new int[n];
    Arrays.fill(t,1);
    
    int lis=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i]){
                t[i]=Math.max(t[i],t[j]+1);
                lis=Math.max(t[i],lis);
            }
        }
    }
    if(lis==Integer.MIN_VALUE) return 1;
    return lis;
    }
}