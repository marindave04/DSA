class Solution {
    static int[][] t=new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        for(int[] row:t){
            Arrays.fill(row,-1);
        }
        return solve(text1,text2,0,0);
    }
    static int solve(String text1, String text2,int i,int j){
        if(i>=text1.length() || j>=text2.length()) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int take=0;
        int first=0;
        int second=0;
        if(text1.charAt(i)==text2.charAt(j)){
            take=1+solve(text1,text2,i+1,j+1);
           
        }else {
             first=solve(text1,text2,i,j+1);
             second=solve(text1,text2,i+1,j);
        }
        return t[i][j]=Math.max(take,Math.max(first,second));
    }
}