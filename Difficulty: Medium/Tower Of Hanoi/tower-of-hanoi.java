class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        return solve(n,0,0,0);
    }  
    static int solve(int n,int from,int to,int aux){
        if(n==0) return 0;
        if(n==1) return 1;
        int x=solve(n-1,from,aux,to);
        int y=solve(n-1,aux,to,from);
        return x+y+1;
    }
}
