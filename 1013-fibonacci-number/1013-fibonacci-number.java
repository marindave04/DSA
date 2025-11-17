class Solution {
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n,dp);
    }
    static int fibo(int n,int[] dp){
        if(n<2) return n;
        if(dp[n]!=-1) return dp[n];
        int a=fibo(n-1,dp);
        int b=fibo(n-2,dp);
        dp[n]=a+b;
        return a+b;
    }
}