class Solution {
    static int N;
    static int M;
    static int K;
    static int mod=(int)1e9+7;
    static int[][][] t=new int[51][101][101];
    public int numOfArrays(int n, int m, int k) {
        N=n;
        M=m;
        K=k;
        for(int i=0;i<51;i++){
            for(int j=0;j<101;j++){
                Arrays.fill(t[i][j],-1);
            }
        }
        return solve(0,0,0);
    }
    static int solve(int idx,int sc,int max){
        if(idx==N){
            if(sc==K) return 1;
            return 0;
        }
        if(t[idx][sc][max]!=-1) return t[idx][sc][max];
         int result=0;
        for(int i=1;i<=M;i++){
            if(i>max){
                result=(result+solve(idx+1,sc+1,i))%mod;
            }else{
                result=(result+solve(idx+1,sc,max))%mod;
            }
        }
        return t[idx][sc][max]=result % mod;
    }
}