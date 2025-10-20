// User function Template for Java

class Solution {
    public int reverseDigits(int n) {
        // Code here
        return reverse(0,n);
    }
    static int reverse(int sum,int n){
        if(n==0){
            return sum;
        }
        sum=sum*10+n%10;
        return reverse(sum,n/10);
    }
}