class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
         long[] prefix=new long[n+1];
        prefix[0]=0;
        for(int i=1;i<n+1;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        long INF = Long.MIN_VALUE;
        for(int p=0;p<k;p++){
            long currSum=0;
            int i=p;
            int j=i+k-1;
            while(j<n){
               long subSum=prefix[j+1]-prefix[i];
               currSum=(long)Math.max(subSum,currSum+subSum);
               INF=(long)Math.max(INF,currSum);
               i=i+k;
               j=i+k-1;
               
            }
        }
        return INF;
    }
}