/*
| Approach                                                            | Time Complexity                          | Space Complexity |
| ------------------------------------------------------------------- | ---------------------------------------- | ---------------- |
| **Sqrt Decomposition + Lazy Multiplication (with Modular Inverse)** | **O(n + q√n + n√n)** (overall amortized) | **O(n)**         |

*/
class Solution {
    int mod=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
       int n=nums.length;
       int blockSize=(int) Math.ceil(Math.sqrt(n));
       Map<Integer,List<int[]>> map=new HashMap<>();
       for(int[] q:queries){
        int l=q[0];
        int r=q[1];
        int K=q[2];
        int v=q[3];
        if(K>=blockSize){
            for(int i=l;i<=r;i+=K){
                nums[i]= (int)((1L*nums[i]*v)%mod);
            }
        }else{
            map.computeIfAbsent(K,k->new ArrayList<>()).add(q);
        }
       }
       for(Map.Entry<Integer,List<int[]>> entry:map.entrySet()){
        int K=entry.getKey();
        List<int[]> all=entry.getValue();
        long[] diff=new long[n];
        Arrays.fill(diff,1);
        for(int[] q:all){
            int l=q[0];
            int r=q[1];
            int v=q[3];
            diff[l]=(diff[l]*v)%mod;
            int steps=(r-l)/K;
            int next=l+(steps+1)*K;
            if(next<n) diff[next]=(diff[next]*pow(v,mod-2))%mod; 
        }
         for(int i=0;i<n;i++){
                if(i-K>=0){
                    diff[i]=(diff[i]*diff[i-K])%mod;
                }
            }
        for(int i=0;i<n;i++){
                nums[i]=(int)((1L*nums[i]*diff[i])%mod);
            }
       }
       int result=0;
       for(int num:nums){
        result=result^num;
       }
       return result;
    }
    long pow(long a, long b) {
        long result = 1;
        a = a % mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }

}
