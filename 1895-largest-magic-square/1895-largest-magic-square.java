class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]rowPrefixSum=new int[m][n];
        int[][]colPrefixSum=new int[m][n];
        
        for (int i = 0; i < m; i++) {
             rowPrefixSum[i][0] = grid[i][0];
             for (int j = 1; j < n; j++) {
                rowPrefixSum[i][j] = rowPrefixSum[i][j - 1] + grid[i][j];
           }
       }
      for(int i=0;i<n;i++){
        colPrefixSum[0][i]=grid[0][i];
        for(int j=1;j<m;j++){
            colPrefixSum[j][i]=colPrefixSum[j-1][i]+grid[j][i];
        }
      }
      int temp=Math.min(m,n);
      for(int side=temp;side>=2;side--){
        for(int i=0;i+side-1<m;i++){
            for(int j=0;j+side-1<n;j++){
                int target=rowPrefixSum[i][j+side-1]-(j>0?rowPrefixSum[i][j-1]:0);
                boolean all=true;
                //check all row of square
                for(int r=i+1;r<i+side;r++){
                    int sum=rowPrefixSum[r][j+side-1]-(j>0?rowPrefixSum[r][j-1]:0);
                    if(sum!=target){
                        all=false;
                        break;
                    }
                }
                if(!all) continue;
                //cheack all column
                for(int c=j;c<j+side;c++){
                    int sum=colPrefixSum[i+side-1][c]-(i>0?colPrefixSum[i-1][c]:0);
                    if(sum!=target){
                        all=false;
                        break;
                    }
                }
                if(!all) continue;
                //check diagonal and antidiagonal
                int diag=0;
                int anti=0;
                for(int k=0;k<side;k++){
                    diag+=grid[i+k][j+k];
                    anti+=grid[i+k][j+side-1-k];
                    
                }
                if(diag==target && anti==target) return side;
            }
        }
      }
      return 1;
    }
}