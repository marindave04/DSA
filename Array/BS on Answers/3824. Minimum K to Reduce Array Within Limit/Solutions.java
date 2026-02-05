class Solution {
    public int minimumK(int[] nums) {
        long low=1;
        long high=(long) 1e9;
        long ans=0;
        while(low<=high){
            long mid=(long)low+(long)(high-low)/2;
            if(check(nums,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return (int)ans;
    }
    boolean check(int[] nums,long mid){
        long op=0;
        for(int i=0;i<nums.length;i++){
            long x=(long)nums[i]/mid;
            long rem=(long)nums[i]%mid;
            if(rem==0){
                op=(long)op+x;
            }else{
                op=(long)op+x+1;
            }
        }
        if(op<=mid*mid) return true;
        return false;
    }
}
