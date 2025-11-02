class Solution {
    public long minimumTime(int[] d, int[] r) {
        long low=0;
        long high= (long) 1e14;
        long ans=-1;
        while(low<=high){
            long mid=low+(high-low)/2;
            long t1=mid-mid/r[0];
            long t2=mid-mid/r[1];
            long gcdd=gcd(r[0],r[1]);
            long lcm=(r[0]/gcdd)*(long)r[1];
            long t3=mid-mid/lcm;
            if(d[0]<=t1 && d[1]<=t2 && d[0]+d[1]<=t3){
                ans=mid;
                high=mid-1;
            }else {
                low = mid+1;
            }
        }
        return ans;
    }
    static long gcd(long a, long b){
        while(b!=0){
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}