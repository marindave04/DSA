/*
| Approach                                                                                                                                                | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Count total `1`s, use sliding window of same size, track how many `1`s are inside each window; swaps needed = missing `1`s in that window, take minimum | **O(n)**        | **O(1)**         |

*/
class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((nums[i]+nums[j])%2!=0){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
