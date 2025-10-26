class Solution {
   static int MOD = 1000000007;

    public int countGoodNumbers(long n) {
       return (int)((pow(5,(n+1)/2)*pow(4,n/2))%MOD);
    }
    static long pow(long x,long n){
        if(n==0) return 1;
        if(n%2==0) return pow((x%MOD*x%MOD)%MOD,n/2)%MOD;
        return (x%MOD*pow((x%MOD*x%MOD)%MOD,(n-1)/2))%MOD;
    }
}