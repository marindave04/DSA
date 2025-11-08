class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=1;
        long high=(long) Arrays.stream(time).min().getAsInt() * (long) totalTrips;
        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(check(mid,time,totalTrips)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static boolean check(long mid,int[] time,int n){
        long count=0;
        for(int i=0;i<time.length;i++){
            if(mid>time[i]){
                count+=mid/time[i];
            }else if(mid==time[i]){
                count++;
            }
        }
        return (count>=n);
    }
}