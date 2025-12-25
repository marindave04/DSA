class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
     Arrays.sort(happiness);
      int n=happiness.length;
      long sum=0;
      long decrement=0;
      for(int i=n-1;i>=0;i--){
        if(k>0){
            long var=(long)happiness[i]-decrement;
            if(var>=0) sum=(long)sum+var;
            decrement++;
            k--;
        }
        
      } 
      return sum; 
    }
}