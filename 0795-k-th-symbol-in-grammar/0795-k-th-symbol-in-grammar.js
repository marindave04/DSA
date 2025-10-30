/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthGrammar = function(n, k) {
    return pos(n,k);
};
 function pos(n,k){
    if(n==1 && k==1){
            return 0;
        }
        const mid=Math.pow(2,n-1)/2;
        if(k<=mid){
            return pos(n-1,k);
        }
        return 1- pos(n-1,k-mid);
 }
  