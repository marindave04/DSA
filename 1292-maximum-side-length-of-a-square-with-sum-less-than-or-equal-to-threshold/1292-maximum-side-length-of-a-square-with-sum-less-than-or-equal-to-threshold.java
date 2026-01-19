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
        int low=0;
        int high=Math.min(m,n);
        while(low<=high){
            int side=low+(high-low)/2;
            if(check(side,m,n,mat,prefix,threshold)){
                max=side;
                low=side+1;
            }else{
                high=side-1;
            }
        }
        
        return max;
    }
    static boolean check(int side ,int m,int n,int[][]mat,int[][] prefix,int threshold){
        if(side==0){
            return true;
        }
        for(int i=0;i+side-1<m;i++){
               
                for(int j=0;j+side-1<n;j++){
                     int r2=i+side-1;
                     int c2=j+side-1;
                     int sum=find(i,j,r2,c2,prefix);
                    if(sum<=threshold){
                        return true;
                    }
                   
                }
            }
            return false;
    }
    static int find(int i,int j,int r2,int c2,int[][] prefix){
        int sum= prefix[r2][c2]-(j>0?prefix[r2][j-1]:0)-(i>0?prefix[i-1][c2]:0)+((i>0 && j>0)?prefix[i-1][j-1]:0);
        return sum;
    }
}