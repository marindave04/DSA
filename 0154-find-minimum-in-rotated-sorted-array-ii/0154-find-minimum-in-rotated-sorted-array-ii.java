class Solution {
    public int findMin(int[] nums) {
         int n=nums.length;
        int high=n-1;
        int low=0;
        int mid=-1;
        while(low<=high){
            while(low<high && nums[low]==nums[low+1]) low++;
            while(high>low && nums[high]==nums[high-1])high--;
            mid=low+(high-low)/2;
            if(nums[low]>=nums[high]){
                if(nums[mid]<nums[low]){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }else{
                high=mid-1;
            }
        }
        return nums[mid];
    }
}