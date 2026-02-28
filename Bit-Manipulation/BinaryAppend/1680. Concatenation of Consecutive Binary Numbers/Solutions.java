//Approach-1
class Solution {
    static int mod=1000000007;
    public int concatenatedBinary(int n) {
     long ans=0;
     int digits=0;
     for(int i=1;i<=n;i++){
        if((i&(i-1))==0) digits++;//checking power of two
        ans=((ans<<digits)%mod+i)%mod;
     }
     return (int)ans;
    }
}
//Approach-2

class Solution {
    static int mod=1000000007;
    public int concatenatedBinary(int n) {
     long ans=0;
     for(int i=1;i<=n;i++){
        int len=(int)(Math.log(i)/Math.log(2))+1;
        ans=((ans<<len)%mod+i)%mod;
     }
     return (int)ans;
    }
}
