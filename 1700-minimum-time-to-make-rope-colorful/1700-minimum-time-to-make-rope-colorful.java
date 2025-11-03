class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum=0;
        int ans=0;
        int max=0;
        for(int i=0;i<neededTime.length;i++){
             sum=neededTime[i];
             max=neededTime[i];
            while(i+1<neededTime.length &&  colors.charAt(i)==colors.charAt(i+1)){
                i++;
               // sum=neededTime[i-1];
                sum +=neededTime[i];
                 max=(int)Math.max(max,neededTime[i]);
              
            }
             ans += sum-max;
             sum=0;
             max=0;
          
             //sum+=neededTime[i];
        }
        return ans;
    }
}