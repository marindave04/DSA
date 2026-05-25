/*
| Approach                                                                                                                                 | Time                     | Space    |
| ---------------------------------------------------------------------------------------------------------------------------------------- | ------------------------ | -------- |
| Sort array, build prefix sums, then use binary search for each query to split left/right costs and compute total operations efficiently. | **O(N log N + Q log N)** | **O(N)** |

*/
class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=queries.length;
        long[] p=new long[n+1];
        List<Long> list=new ArrayList<>();
        p[0]=(long)nums[0];
        for(int i=1;i<n;i++){
            p[i]=(long)p[i-1]+nums[i];
        }
        for(int i=0;i<m;i++){
            int target=queries[i];
            int idx=solve(nums,target);
            //left part
            int N=idx+1;
            long left=1L*target*N-(long)(idx>=0 ? p[idx]:0);
            //right part;
            idx=idx+1;
            N=n-idx;
            long right=(long)(p[n-1]-(idx-1>=0 ? p[idx-1] : 0))-1L*target*N;
            long ans=(long) left+right;
            list.add(ans);
        }
        return list;
    }
    static int solve(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
