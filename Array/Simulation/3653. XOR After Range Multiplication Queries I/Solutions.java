/*
| Approach                                                | Time Complexity        | Space Complexity |
| ------------------------------------------------------- | ---------------------- | ---------------- |
| **Brute Force Simulation (Range + Step Updates + XOR)** | **O(Q × (R−L)/K + N)** | **O(1)**         |

*/

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        for(int q=0;q<queries.length;q++){
            int l=queries[q][0];
            int r=queries[q][1];
            int k=queries[q][2];
            int v=queries[q][3];
            int idx=l;
            while(idx<=r){
                nums[idx] = (int)(((long)nums[idx] * v) % mod);
                idx+=k;
            }
        }
        long xor=0;
        for(int i=0;i<nums.length;i++){
            xor=(long)xor^nums[i];
        }
        return (int)xor;
    }
}
