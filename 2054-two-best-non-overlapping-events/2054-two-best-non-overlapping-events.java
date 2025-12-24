class Solution {
    static int[][]dp=new int[100001][3];
    public int maxTwoEvents(int[][] events) {
      Arrays.sort(events,(a,b)->a[0]-b[0]);
      for(int i=0;i<100001;i++){
        for(int j=0;j<3;j++){
            dp[i][j]=-1;
        }
      }
      return solve(events,0,0);
    }
    static int solve(int[][] events,int i,int count){
        if(i>=events.length || count==2) return 0;
        if(dp[i][count]!=-1) return dp[i][count];
        int valid=bs(events,events[i][1]);
        int take=events[i][2]+solve(events,valid,count+1);
        int skip=solve(events,i+1,count);
        return dp[i][count]=Math.max(take,skip);
    }
    static int bs(int[][] events,int temp){
        int l=0;
        int r=events.length-1;
        int ans=events.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(events[mid][0]>temp){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}