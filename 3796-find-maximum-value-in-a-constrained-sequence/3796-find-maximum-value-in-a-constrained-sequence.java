class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
       int[] ans=new int[n];
       Arrays.fill(ans,Integer.MAX_VALUE);
       ans[0]=0;
       for(int i=0;i<restrictions.length;i++){
        ans[restrictions[i][0]]=restrictions[i][1];
       }
       for(int i=0;i<=n-2;i++){
        if(ans[i]!=Integer.MAX_VALUE){
            ans[i+1]=(int)Math.min(ans[i+1],ans[i]+diff[i]);
        }
       }
       for(int i=n-2;i>=0;i--){
         ans[i]=(int)Math.min(ans[i],ans[i+1]+diff[i]);
       }
       int max=Arrays.stream(ans).max().getAsInt();
       return max;
    }
}