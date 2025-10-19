class Solution {
    public int fib(int n) {
        return fibo(n);
    }
    static int fibo(int n){
        if(n<2) return n;
        int a=fibo(n-1);
        int b=fibo(n-2);
        return a+b;
    }
}