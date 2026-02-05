class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                int step=nums[i];
                result[i]=nums[(i+step)%n];
            }else if(nums[i]<0){
                int step=Math.abs(nums[i]);
                result[i]=nums[(i-step%n+n)%n];
            }else{
                result[i]=nums[i];
            }
        }
        return result;
    }
}
