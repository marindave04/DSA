/*
| Approach                                                                                                                  | Time Complexity   | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------- | ----------------- | ---------------- |
| Flatten grid into array, sort it, choose median as target, verify modulo compatibility, then count required ±x operations | **O(mn log(mn))** | **O(mn)**        |

*/
class Solution {
    public int minOperations(int[][] grid, int x) {
     int m=grid.length;
     int n=grid[0].length;
     int[] nums=new int[m*n];
     int idx=0;
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            nums[idx++]=grid[i][j];
        }
     }
     Arrays.sort(nums);
     int target=nums[(int)Math.floor(nums.length/2)];
     int ans=0;
     for(int num:nums){
        if(target%x!=num%x) return -1;
        ans=ans+Math.abs(target-num)/x;
     }
     return ans;
    }
}
