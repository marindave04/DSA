class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        return solve(n,from,to,aux);
    }
    static int solve(int n, int from, int to, int aux){
        if(n==0) return 0;
        if(n==1) return 1;
        
        int count=solve(n-1,from,aux,to);
        count++;
        count=count+solve(n-1,aux,to,from);
        return count;
    }
}
