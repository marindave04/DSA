class Solution {
    static int[][] t=new int[1002][1002];
    public int findLongestChain(int[][] pairs) {
        for(int[] row:t){
            Arrays.fill(row,-2);
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(pairs,0,-1);
    }
    static int solve(int[][]pairs,int i,int p){
        if(i>=pairs.length) return 0;
       if(p!=-1&&t[i][p]!=-2) return t[i][p];
        int take=0;
        if(p==-1||pairs[i][0]>pairs[p][1]){
            take=1+solve(pairs,i+1,i);
        }
        int skip=solve(pairs,i+1,p);
        if(p!=-1) {
            return t[i][p]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}