/*
| Approach                                                                                                                   | Time                                 | Space    |
| -------------------------------------------------------------------------------------------------------------------------- | ------------------------------------ | -------- |
| Use modified binary search on rotated sorted array with duplicates, skipping equal elements to locate the minimum element. | **O(log N)** average, **O(N)** worst | **O(1)** |

*/
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]<nums[n-1]) return nums[0];
        int low=0;
        int high=n-1;
        int mid=-1;
        while(low<=high){
            while(low<high && nums[low]==nums[low+1]) low++;
            while(high>low && nums[high]==nums[high-1]) high--;
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
