class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] rowPrefixSum=new int[m][n];
        for(int i=0;i<m;i++){
            rowPrefixSum[i][0]=mat[i][0];
            for(int j=1;j<n;j++){
                rowPrefixSum[i][j]=rowPrefixSum[i][j-1]+mat[i][j];
            }
        }
        for(int side=Math.min(m,n);side>=1;side--){
            for(int i=0;i+side-1<m;i++){
               
                for(int j=0;j+side-1<n;j++){
                     int sum=0;
                    for(int k=i;k<i+side;k++){
                          sum+=rowPrefixSum[k][j+side-1]-(j>0?rowPrefixSum[k][j-1]:0);
                    }
                    if(sum<=threshold) return side;
                }
            }
        }
        return 0;
    }
}