class Solution {
     private int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;
        int[][] count=new int[l][2];
        for(int i=0;i<l;i++){
            int count0=0;
            int count1=0;
            for(Character ch:strs[i].toCharArray()){
                if(ch=='0') count0++;
                else count1++;
            }
            count[i][0]=count0;
            count[i][1]=count1;
        }
         dp = new int[m + 1][n + 1][l];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
       return solve(count,m,n,0);
    }
     private int solve(int[][] count, int m, int n, int index) {
        if (index >= count.length || (m == 0 && n == 0))
            return 0;

        if (dp[m][n][index] != -1)
            return dp[m][n][index];

        int include = 0;
        if (count[index][0] <= m && count[index][1] <= n) {
            include = 1 + solve(count, m - count[index][0], n - count[index][1], index + 1);
        }

        int exclude = solve(count, m, n, index + 1);

        return dp[m][n][index] = Math.max(include, exclude);
    }

}