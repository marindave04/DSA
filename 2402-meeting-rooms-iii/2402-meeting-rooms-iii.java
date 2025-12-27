class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m=meetings.length;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        long[] available =new long[n];
        int[] used=new int[n];

        for(int i=0;i<m;i++){
            int start=meetings[i][0];
            int end=meetings[i][1];
            int duration=end-start;
            boolean found=false;
            long earlyEndTime=Long.MAX_VALUE;
            int earlyRoom=0;
            for(int room=0;room<n;room++){
                if(available[room]<=start){
                    available[room]=end;
                    used[room]++;
                    found=true;
                    break;
                }
                if(available[room]<earlyEndTime){
                    earlyEndTime=available[room];
                    earlyRoom=room;
                }
            }
            if(!found){
                available[earlyRoom]=earlyEndTime+duration;
                used[earlyRoom]++;
            }
        }
       int result=-1;
       int maxUse=0;
       for(int i=0;i<n;i++){
        if(used[i]>maxUse){
            maxUse=used[i];
            result=i;
        }
       }
       return result;
    }
}