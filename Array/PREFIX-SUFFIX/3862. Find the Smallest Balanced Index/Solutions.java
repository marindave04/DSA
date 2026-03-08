
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long[] psum=new long[n];
       
        int ans=Integer.MAX_VALUE;
        psum[0]=nums[0];
        for(int i=1;i<n;i++){
            psum[i]=(long)psum[i-1]+nums[i];
        }
        long suffix=1;
        long limit=psum[n-1];
        for(int i=n-1;i>=0;i--){
           long left=(i>0 ? psum[i-1] :0);
          
            if(left==suffix){
                ans=Math.min(ans,i);
            }
             suffix=(long) suffix*nums[i];
            if(suffix>limit) break;
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}
