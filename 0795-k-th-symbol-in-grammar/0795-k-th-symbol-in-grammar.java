class Solution {
    public int kthGrammar(int n, int k) {
     return pos(n,k);
    }
    static int pos(int n,int k){
        if(n==1 && k==1){
            return 0;
        }
        int mid=(int)Math.pow(2,n-1)/2;
        if(k<=mid){
            return pos(n-1,k);
        }
        return 1- pos(n-1,k-mid);
    }
}