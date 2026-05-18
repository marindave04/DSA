/*
| Approach                                                                                                                     | Time         | Space    |
| ---------------------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Use binary search and parity of subarray lengths around duplicate pairs to determine which side contains the single element. | **O(log N)** | **O(1)** |

*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
         int n=nums.length;
         int low=0;
         int high=n-1;
         if(n==1) return nums[0];
         if(nums[0]!=nums[1]) return nums[0];
         if(nums[n-1]!=nums[n-2]) return nums[n-1];
         while(low<=high){
            int mid=low+(high-low)/2;
            if(mid-1>=0 && mid+1<n && nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else{
                int lc=0;
                int rc=0;
                if(mid-1>=0 && nums[mid]==nums[mid-1]){
                 lc=mid-low+1;
                 rc=high-mid;
                 if(lc%2!=0) high=mid;
                 if(rc%2!=0) low=mid+1;
                }else{
                 lc=mid-low;
                 rc=high-mid+1;
                 if(lc%2!=0) high=mid-1;
                 if(rc%2!=0) low=mid;
                }
            }
         }
         return 0;
    }
}
/*
| Approach                                                                                                                         | Time         | Space    |
| -------------------------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Use binary search with index parity; before the single element pairs start at even indices, after it pairs start at odd indices. | **O(log N)** | **O(1)** |

*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
         int n=nums.length;
         int low=0;
         int high=n-1;
         if(n==1) return nums[0];
         if(nums[0]!=nums[1]) return nums[0];
         if(nums[n-1]!=nums[n-2]) return nums[n-1];
         while(low<=high){
            int mid=low+(high-low)/2;
            if(mid-1>=0 && mid+1<n && nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else{
                if(mid%2==0){
                    if(mid-1>=0 && nums[mid]==nums[mid-1]){
                        high=mid-1;
                    }else if(mid+1<n && nums[mid]==nums[mid+1]){
                        low=mid+2;
                    }
                }else{
                    if(mid-1>=0 && nums[mid]==nums[mid-1]){
                        low=mid+1;
                    }else if(mid+1<n && nums[mid]==nums[mid+1]){
                        high=mid-1;
                    }
                }
            }
         }
         return 0;
    }
}
