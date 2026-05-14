/*
| Approach                                                                                                                      | Time             | Space    |
| ----------------------------------------------------------------------------------------------------------------------------- | ---------------- | -------- |
| Try every possible target sum from `1` to `2*limit`, and for each pair determine whether `0`, `1`, or `2` changes are needed. | **O(N × limit)** | **O(1)** |

*/

class Solution {
    public int minMoves(int[] nums, int limit) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        for(int sum=1;sum<=2*limit;sum++){
            int moves=0;
            for(int i=0;i<n/2;i++){
                int a=nums[i];
                int b=nums[n-i-1];
                int minValue=Math.min(a,b)+1;
                int maxValue=Math.max(a,b)+limit;
                if(sum==a+b){
                    continue;
                }else if(sum>=minValue && sum<=maxValue){
                    moves+=1;
                }else{
                    moves+=2;
                }
            }
            ans=Math.min(ans,moves);
        }
        return ans;
    }
}
/*
| Approach                                                                                                                                                 | Time             | Space        |
| -------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------- | ------------ |
| Use difference array to mark move contributions for every possible pair sum, then apply prefix sum to get minimum moves for each target sum efficiently. | **O(N + limit)** | **O(limit)** |

*/
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] diff=new int[2*limit+2];
         for(int i=0;i<n/2;i++){
                int a=nums[i];
                int b=nums[n-i-1];
                int minValue=Math.min(a,b)+1;
                int maxValue=Math.max(a,b)+limit;
                diff[2]+=2;
                diff[2*limit+1]-=2;
                diff[minValue]+=(-1);
                diff[maxValue+1]-=(-1);
                diff[a+b]+=(-1);
                diff[a+b+1]-=(-1);
            }
            int[] cumSum=new int[diff.length];
            cumSum[2]=diff[2];
            int ans=cumSum[2];
            for(int i=3;i<=2*limit;i++){
                cumSum[i]=cumSum[i-1]+diff[i];
                ans=Math.min(ans,cumSum[i]);
            }
        return ans;
    }
}
