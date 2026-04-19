/*
| Approach                                       | Time Complexity | Space Complexity |
| ---------------------------------------------- | --------------- | ---------------- |
| **Prefix Max + Suffix Min (Range Validation)** | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int firstStableIndex(int[] nums, int k) {
         int n=nums.length;
        int[] max=new int[n];
        int[] min=new int[n];
        max[0]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max[i-1]){
                max[i]=nums[i];
            }else{
                max[i]=max[i-1];
            }
        }
        min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]<min[i+1]){
                min[i]=nums[i];
            }else{
                min[i]=min[i+1];
            }
        }
        for(int i=0;i<n;i++){
            if(max[i]-min[i]<=k) return i;
        }
        return -1;
    }
}
