class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] prefix=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefix[i][j]= (i>0?prefix[i-1][j]:0)+(j>0?prefix[i][j-1]:0)-((i>0 && j>0)?prefix[i-1][j-1]:0)+mat[i][j];
            }
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=Math.min(m-i,n-j)-1;k++){
                    int r2=i+k;
                    int c2=j+k;
                    int sum=find(i,j,r2,c2,prefix);
                    if(sum<=threshold){
                        max=Math.max(max,k+1);
                    }else {
                        break;
                    }
                }
            }
        }
        return max;
    }
    static int find(int i,int j,int r2,int c2,int[][] prefix){
        int sum= prefix[r2][c2]-(j>0?prefix[r2][j-1]:0)-(i>0?prefix[i-1][c2]:0)+((i>0 && j>0)?prefix[i-1][j-1]:0);
        return sum;
    }
}