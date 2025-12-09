class Solution {
    public int largestPrime(int n) {
        int sum=0;
        int ans=0;
        int i=2;
        while(sum<=n){
            if(check(i)){
                sum=sum+i;
                if(check(sum)&&sum<=n){
                    ans=sum;
                }
            }
            i++;
        }
        return ans;
    }
    boolean check(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        
        for(int i=3;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}