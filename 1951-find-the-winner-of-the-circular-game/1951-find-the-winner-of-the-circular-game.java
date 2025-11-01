class Solution {
    public int findTheWinner(int n, int k) {
     return solve(n,k)+1;
}
static int solve(int n,int k){
    if(n==1){
        return 0;
    }
    int idx=solve(n-1,k);
    return (idx+k)%n;
}
}