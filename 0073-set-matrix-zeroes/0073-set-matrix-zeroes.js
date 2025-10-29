/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let m=matrix.length;
    let n=matrix[0].length;
    let map1=new Map();
    let map2=new Map();
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){
            if(matrix[i][j]==0){
                map1.set(i,matrix[i][j]);
                map2.set(j,matrix[i][j]);
            }
        }
    }
    for(let [key,value] of map1.entries()){
        if(value==0){
            let row=key;
            for (let p = 0; p < n; p++) {
                matrix[row][p] = 0;
            }
        }
    }
    for(let [key,value] of map2.entries()){
        if(value==0){
            let col=key;
            for (let q = 0; q < m; q++) {
                matrix[q][col] = 0;
            }
        }
    }
};