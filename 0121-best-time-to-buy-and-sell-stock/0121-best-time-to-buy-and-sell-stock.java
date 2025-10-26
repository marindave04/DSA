class Solution {
    public int maxProfit(int[] prices) {
      int n=prices.length;
      int j=n-1;
      int i=n-2;
      int profit=0;
      while(i>=0){
         if(prices[i]>prices[j]){
            j=i;
            i--;
         }else{
            int temp=prices[j]-prices[i];
            profit=Math.max(profit,temp);
            i--;

         }
      }
      return profit;
    }
}