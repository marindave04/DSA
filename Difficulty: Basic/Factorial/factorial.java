class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // code here
        return f(n);
    }
    static int f(int n){
        if(n==1) return 1;
        int a=n*f(n-1);
        return a;
    }
}
