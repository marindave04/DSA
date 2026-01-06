class Solution {
   
    public int findLongestChain(int[][] pairs) {
      
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
         int n=pairs.length;
    int[] t=new int[n];
    Arrays.fill(t,1);
    
    int lis=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            if(pairs[j][1]<pairs[i][0]){
                t[i]=Math.max(t[i],t[j]+1);
                lis=Math.max(t[i],lis);
            }
        }
    }
    if(lis==Integer.MIN_VALUE) return 1;
    return lis;
  
    }
}