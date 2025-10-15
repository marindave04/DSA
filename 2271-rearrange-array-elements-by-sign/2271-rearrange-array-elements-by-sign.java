class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] positive=new int[n/2];
        int[] negative=new int[n/2];
        int index1=0;
        int index2=0;
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0) positive[index1++]=nums[i];
            if(nums[i]<0) negative[index2++]=nums[i];
        }
        for(int i=0;i<n/2;i++){
            nums[index++]=positive[i];
            nums[index++]=negative[i];
        }
        return nums;
    }
}