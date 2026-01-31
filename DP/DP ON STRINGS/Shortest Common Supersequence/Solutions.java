//TOP-DOWN APPROACH WITH MEMOIZATION
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
//BOTTOM-UP TABULATION APPROACH
class Solution {
    
    public static int minSuperSeq(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
       int[][] t=new int[m+1][n+1];
       for(int i=0;i<m+1;i++){
           for(int j=0;j<n+1;j++){
               if(i==0 || j==0){
                   t[i][j]=i+j;
               }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                   t[i][j]=1+t[i-1][j-1];
               }else{
                   t[i][j]=1+Math.min(t[i-1][j],t[i][j-1]);
               }
           }
       }
       return t[m][n];
    }
}
//USING LCS BOTTOM CONCEPT
class Solution {
    
    public static int minSuperSeq(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
       int[][] t=new int[m+1][n+1];
       //using lcs
       for(int i=0;i<m+1;i++){
           for(int j=0;j<n+1;j++){
               if(i==0 || j==0){
                   t[i][j]=0;
               }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                   t[i][j]=1+t[i-1][j-1];
               }else{
                   t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
               }
           }
       }
       return t[m][n]+(m-t[m][n])+(n-t[m][n]);
    }
}
