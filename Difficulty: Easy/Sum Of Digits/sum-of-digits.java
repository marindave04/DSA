class Solution {
    static int sumOfDigits(int n) {
        // code here
        return sum(n);
    }
    static int sum(int n){
        if(n==0) return 0;
        return n%10+sum(n/10);
    }
}
