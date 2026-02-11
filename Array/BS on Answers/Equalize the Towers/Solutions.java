class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int s=Arrays.stream(heights).min().getAsInt();
        int e=Arrays.stream(heights).max().getAsInt();
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            
            int seg1=check(heights,cost,mid-1);
            int seg=check(heights,cost,mid);
            int seg2=check(heights,cost,mid+1);
            
            if(seg<=seg1 && seg<=seg2){
                ans=seg;
                break;
            }else if(seg1>=seg && seg>=seg2){
                s=mid+1;
            }else if(seg2>seg && seg>=seg1){
                e=mid-1;
            }
        }
        return ans;
    }
    public static int check(int[] heights, int[] cost,int h){
        int costs=0;
        for(int i=0;i<heights.length;i++){
            costs+=cost[i]*Math.abs(heights[i]-h);
        }
        return costs;
    }
}
