class Solution {
    static int[][] dp=new int[1001][1001];
    public int longestStrChain(String[] words) {
      for(int[] row:dp){
        Arrays.fill(row,-1);
      }
      Arrays.sort(words,(a,b)->a.length()-b.length());
      return solve(words,0,-1);  
    }
    static int solve(String[]words,int i,int p){
        if(i>=words.length) return 0;
        if(p>-1 && dp[i][p]!=-1) return dp[i][p];
        int take=0;
        if(p==-1 || valid(words[p],words[i])){
             take=1+solve(words,i+1,i);
        }
        int skip=solve(words,i+1,p);
        if(p==-1) return Math.max(take,skip);
        return dp[i][p]=Math.max(take,skip);
    }
    static boolean valid(String s1, String s2) {
    if (s2.length() != s1.length() + 1) return false;

    int i = 0, j = 0;
    boolean skipped = false;

    while (i < s1.length() && j < s2.length()) {
        if (s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        } else {
            if (skipped) return false;
            skipped = true;
            j++; // extra character in s2
        }
    }
    return true;
}

}