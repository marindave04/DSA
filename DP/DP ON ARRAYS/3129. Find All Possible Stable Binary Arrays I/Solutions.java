/*
| Approach                      | Time Complexity           | Space Complexity  |
| ----------------------------- | ------------------------- | ----------------- |
| **Top-Down DP (Memoization)** | **O(zero × one × limit)** | **O(zero × one)** |

*/
class Solution {
    static int mod=1000000007;
    static int[][][] t=new int[201][201][2];
    public int numberOfStableArrays(int zero, int one, int limit) {
        for(int[][] a:t){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        int s0=(solve(zero,one,1,limit))%mod;
        int s1=(solve(zero,one,0,limit))%mod;
        return (s0+s1)%mod;
    }
    static int solve(int zero,int one,int lastOne,int limit){
        if(zero==0 && one==0 ) return 1;
        if(t[zero][one][lastOne]!=-1) return t[zero][one][lastOne];
        int res=0;
        if(lastOne==1){
            for(int l=1;l<=Math.min(zero,limit);l++){
                res=(res+solve(zero-l,one,0,limit))%mod;
            }
        }else{
            for(int l=1;l<=Math.min(one,limit);l++){
                res=(res+solve(zero,one-l,1,limit))%mod;
            }
        }
        return t[zero][one][lastOne]=res ;
    }
}
