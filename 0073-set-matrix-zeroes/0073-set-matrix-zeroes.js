/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let m=matrix.length;
    let n=matrix[0].length;
    //check if first row is impacted
        let firstRowImpacted=false;
        for(let col=0;col<n;col++){
            if(matrix[0][col]==0){
            firstRowImpacted=true;
            }
        }
        //check if first col is impacted
        let firstColImpacted=false;
        for(let row=0;row<m;row++){
            if(matrix[row][0]==0){
            firstColImpacted=true;
            }
        }
         //marking two flags which will helps us whic rows and columns are impacted
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            if(matrix[i][j]==0){
               matrix[i][0]=0;
               matrix[0][j]=0;
            }
        }
    }
     for(let i=1;i<m;i++){
            for(let j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowImpacted){
            for(let col=0;col<n;col++){
           matrix[0][col]=0;
        }
        }
        if(firstColImpacted){
            for(let row=0;row<m;row++){
            matrix[row][0]=0;
        }
        }
    
};