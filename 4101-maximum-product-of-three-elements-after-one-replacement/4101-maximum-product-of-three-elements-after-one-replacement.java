class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
        int fmax=Integer.MIN_VALUE;
        int imax=-1;
        int a=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(Math.abs(nums[i])>=fmax){
                fmax=(int)Math.abs(nums[i]);
                a=nums[i];
                imax=i;
            }
        }
        int smax=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i==imax) continue;
            if(Math.abs(nums[i])>=smax){
                smax=(int)Math.abs(nums[i]);
                b=nums[i];
            }
        }
        long product=1;
        if((a<0 && b<0) || (a>0 && b>0)){
            product=(long)a*b*100000L;
            return product;
        }
        if((a<0 && b>0) || (a>0 && b<0)){
            product=(long)a*b*(-100000L);
            return product;
        }
        return 0;
    }
}