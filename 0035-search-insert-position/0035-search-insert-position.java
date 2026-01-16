class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int ans=n;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target<=nums[mid]){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}