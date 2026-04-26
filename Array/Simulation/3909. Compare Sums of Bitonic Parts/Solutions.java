/*
| Approach                                                                                          | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Find first decreasing point as peak, compute left bitonic sum and right bitonic sum, then compare | **O(n)**        | **O(1)**         |

*/
class Solution {
    public int compareBitonicSums(int[] nums) {
        int peak=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                peak=i;
                break;
            }
        }
        long sum1=0;
        for(int i=0;i<=peak;i++){
            sum1=(long) sum1+nums[i];
        }
        long sum2=0;
        for(int i=peak;i<nums.length;i++){
            sum2=(long)sum2+nums[i];
        }
        if(sum1>sum2) return 0;
        if(sum2>sum1) return 1;
        return -1;
    }
}
