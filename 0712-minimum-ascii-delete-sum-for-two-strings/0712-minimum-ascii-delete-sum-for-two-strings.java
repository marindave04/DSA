class Solution {
    static int[][] t=new int[1001][1001];
    public int minimumDeleteSum(String s1, String s2) {
        for(int[] row:t){
            Arrays.fill(row,-1);
        }
        return solve(s1,s2,0,0);
    }
    static int solve(String s1,String s2,int i,int j){
        if(i>=s1.length() && j>=s2.length()) return 0;
        if(t[i][j]!=-1) return t[i][j];
        if(i>=s1.length()) return (s2.charAt(j)-0)+solve(s1,s2,i,j+1);
        if(j>=s2.length()) return (s1.charAt(i)-0)+solve(s1,s2,i+1,j);
        if(s1.charAt(i)==s2.charAt(j)) return solve(s1,s2,i+1,j+1);

        int deleteS1=(s1.charAt(i)-0) + solve(s1,s2,i+1,j);
        int deleteS2=(s2.charAt(j)-0) + solve(s1,s2,i,j+1);
        return t[i][j]=Math.min(deleteS1,deleteS2);
    }
}