class Solution {
    static int[][] t=new int[501][501];
    public static int minSuperSeq(String s1, String s2) {
        // code here
        for(int[] row:t){
            Arrays.fill(row,-1);
        }
        return solve(s1,s2,s1.length(),s2.length());
    }
    static int solve(String s1,String s2,int i,int j){
        if(j<=0){
            return i;
        }else if(i<=0) return j;
        if(t[i][j]!=-1) return t[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return t[i][j] = 1+solve(s1,s2,i-1,j-1);
        }
        
        return t[i][j] = 1+Math.min(solve(s1,s2,i-1,j),solve(s1,s2,i,j-1));
    }
}