class Solution {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        long count=0;
        int i=0;
        int j=1;
        int window=0;
        while(j<n){
            if(prices[j]==prices[j-1]-1){
                j++;
            }else{
                window=j-i;
                count=count+((long)window*(window+1)/2);
                i=j;
                j++;
            }
        }
        if(i==n-1)  return (long) count+1;
        if(i<n-1){
            int temp=j-i;
            count=count+((long)temp*(temp+1)/2);
        }
        return count;
    }
}