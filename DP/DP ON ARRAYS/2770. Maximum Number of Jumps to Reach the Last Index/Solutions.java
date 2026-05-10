/*
| Approach                                                        | Time      | Space    |
| --------------------------------------------------------------- | --------- | -------- |
| DP + recursion with memoization, try all reachable next indices | **O(n²)** | **O(n)** |

*/
class Solution {
    static int n;
    static int[] t=new int[1001];
    public int maximumJumps(int[] nums, int target) {
        n=nums.length;
        Arrays.fill(t,-1);
        int temp= solve(0,nums,target);
        if(temp>0 && temp<=n-1) return temp;
        return -1;
    }
    static int solve(int i,int[] nums,int target){
        if(i==n-1) return 0;
        if(t[i]!=-1) return t[i];
        int ans=Integer.MIN_VALUE;
        for(int j=i+1;j<n;j++){
            if(Math.abs(nums[i]-nums[j])<=target){
                int temp=1+solve(j,nums,target);
                ans=Math.max(temp,ans);
            }
        }
        return t[i]=ans;
    }
}
