class Solution {
    public static int findSum(int n) {
        // code here
      return  sum(n);
    }
    static int sum(int n){
        if(n==1) return 1;
        int a=n+sum(n-1);
        return a;
    }
}
