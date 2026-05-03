/*
| Approach                                                                                                                                                                    | Time Complexity     | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------- | ---------------- |
| Reverse the number, iterate through the inclusive range between original and reversed value, check each number for primality using trial division, and accumulate prime sum | **O((b-a+1) × √b)** | **O(1)**         |

*/
class Solution {
    public int sumOfPrimesInRange(int n) {
        int r=rev(n);
        int a=Math.min(n,r);
        int b=Math.max(n,r);
        int sum=0;
        for(int i=a;i<=b;i++){
            if(prime(i)) sum+=i;
        }
        return sum;
    }
    static boolean prime(int n){
        if(n<=0) return false;
        if(n==1) return false;
        if(n==2) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    static int rev(int n){
        int ans=0;
        while(n>0){
            int rem=n%10;
            ans=rem+ans*10;
            n=n/10;
        }
        return ans;
    }
}
