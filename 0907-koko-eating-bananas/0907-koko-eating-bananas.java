class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        long low=1;
        long high=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     low=(long)Math.min(low,piles[i]);
        // }
        for(int i=0;i<n;i++){
            high=(long)Math.max(high,piles[i]);
        }
        long ans=0;
        while(low<=high){
            long k=low+(high-low)/2;
            if(solve(piles,h,k)){
                ans=k;
                high=k-1;
            }else{
                low=k+1;
            }
        }
        return (int)ans;
    }
    static boolean solve(int[] nums,long h,long k){
        long count=0;
        for(int i=0;i<nums.length;i++){
           long rem=nums[i]%k;
           if(rem>0)count = count + nums[i]/k +1;
           else count=count+nums[i]/k;
        }
        if(count<=h) return true;
        return false;
    }
    
}