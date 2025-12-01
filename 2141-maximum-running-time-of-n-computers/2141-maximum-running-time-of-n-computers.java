class Solution {
    public long maxRunTime(int n, int[] batteries) {
  // Arrays.sort(batteries);
     long s=0;
     long e=0;
     for(int i=0;i<batteries.length;i++){
        e+=batteries[i];
     }
     long ans=0;
     while(s<=e){
        long mid=s+(e-s)/2;
        if(solve(mid,batteries,n)){
           ans=mid;
           s=mid+1;
        }else{
            e=mid-1;
        }
     }
     return ans;
    }
    static boolean solve(long mid,int[] batteries,int n){
         long target = mid * (long) n; 
        long temp=0;
        for(int i=0;i<batteries.length;i++){
            if(batteries[i]>mid){
                temp=temp+mid;
            }else{
                temp=temp+batteries[i];
            }
        }
        if(temp>=target) return true;
        return false;
    }
}