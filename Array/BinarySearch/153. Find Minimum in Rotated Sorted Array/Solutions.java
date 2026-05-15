/*
| Approach                                                                                                       | Time         | Space    |
| -------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Apply binary search on rotated sorted array to locate the pivot/minimum element using neighboring comparisons. | **O(log N)** | **O(1)** |

*/
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(nums[0]<=nums[n-1]) return nums[0];
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid-1>=0 && nums[mid]<nums[mid-1]) && (mid+1<n && nums[mid]<nums[mid+1])){
                return nums[mid];
            }else if(mid==n-1 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(mid==0 && nums[mid]<nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]>=nums[0]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return 0;
    }
}
