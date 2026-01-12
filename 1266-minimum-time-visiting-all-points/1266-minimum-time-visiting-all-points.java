class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        if(n==1) return 0;
        int time=0;
        for(int i=1;i<n;i++){
            int x1=points[i-1][0];
            int x2=points[i][0];
            int y1=points[i-1][1];
            int y2=points[i][1];
            int xTime=Math.abs(x2-x1);
            int yTime=Math.abs(y2-y1);
            time+=Math.max(xTime,yTime);
        }
        return time;
    }
}