class Solution {
    public void setZeroes(int[][] matrix) {
        int m =matrix.length;
        int n =matrix[0].length;
        //check if first row is impacted
        boolean firstRowImpacted=false;
        for(int col=0;col<n;col++){
            if(matrix[0][col]==0){
            firstRowImpacted=true;
            }
        }
        //check if first col is impacted
        boolean firstColImpacted=false;
        for(int row=0;row<m;row++){
            if(matrix[row][0]==0){
            firstColImpacted=true;
            }
        }
        //marking two flags which will helps us whic rows and columns are impacted
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                   matrix[i][0]=0;
                   matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowImpacted){
            for(int col=0;col<n;col++){
           matrix[0][col]=0;
        }
        }
        if(firstColImpacted){
            for(int row=0;row<m;row++){
            matrix[row][0]=0;
        }
        }
    }
}