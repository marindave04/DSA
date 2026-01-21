class Solution {
    
    static int mod=(int)1e9+7;

    public int countGoodNumbers(long n) {
      long even=(n+1)/2;
      long odd = (n)/2;
      long ans=powmod(5,even) * powmod(4,odd) % mod;
      return (int) ans;
    }
    static long powmod(long x,long y){
        if(y==0) return 1;
        long half=powmod(x,y/2);
        half=(half*half)%mod;
        if(y%2==1){
            half=(x*half)%mod;
        }
        return half;
    }
}