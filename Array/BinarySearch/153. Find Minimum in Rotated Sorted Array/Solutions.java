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
/*| Approach                                                                                                                     | Time         | Space    |
| ---------------------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Use binary search to locate the rotation pivot/valley point by comparing middle element with neighbors and array end values. | **O(log N)** | **O(1)** |
*/
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        //first we will find valley point;
        int min=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid-1>=0 && mid+1<n && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            }else if(mid+1< n && nums[mid]>nums[mid+1]){
               return nums[mid+1];
            }else if(nums[mid]<=nums[n-1]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return nums[0];
    }
}
