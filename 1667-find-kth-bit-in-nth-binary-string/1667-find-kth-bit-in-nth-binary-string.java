class Solution {
    public char findKthBit(int n, int k) {
        return solve(n,k);
    }
    static char solve(int n,int k){
        if(n==1){
            return '0';
        }
    
        if(k==(int)Math.ceil(((1<<n)-1)/2.0)){
            return '1';
        }
        if(k>(int)Math.ceil(((1<<n)-1)/2.0)){
            char c = solve(n-1,((1<<n)-1)-(k-1));
            return c == '0' ? '1' : '0';
        }
        return solve(n-1,k);
    }
    
}