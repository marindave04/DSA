/*
| Approach                                                                                                                 | Time         | Space    |
| ------------------------------------------------------------------------------------------------------------------------ | ------------ | -------- |
| First find rotation pivot using binary search, then apply binary search separately on both sorted halves to find target. | **O(log N)** | **O(1)** |

*/
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        //first we will find valley point;
        int min=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid-1>=0 && mid+1<n && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                min=mid;
                break;
            }else if(mid+1< n && nums[mid]>nums[mid+1]){
                min=mid+1;
                break;
            }else if(nums[mid]<=nums[n-1]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        int l1=0;
        int r1=min-1;
        int l2=min;
        int r2=n-1;
        while(l1<=r1){
            int mid=l1+(r1-l1)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                r1=mid-1;
            }else{
                l1=mid+1;
            }
        }
         while(l2<=r2){
            int mid=l2+(r2-l2)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                r2=mid-1;
            }else{
                l2=mid+1;
            }
        }
        return -1;
    }
}
/*
| Approach                                                                                                        | Time         | Space    |
| --------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Use modified binary search to identify which half is sorted, then move towards the half where target can exist. | **O(log N)** | **O(1)** |

*/
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        //first we will find valley point;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            //check if we are in a left part or right part
            if(nums[mid]<=nums[high]){
                //means we are in a right part
                //now check the range of target
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }else {
               // means we are in a left sorted part
               if(target<nums[mid] && target>=nums[low]){
                high=mid-1;
               }else{
                low=mid+1;
               }
            }
        }
        return -1;
    }
}
