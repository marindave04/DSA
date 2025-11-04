class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int high=Integer.MIN_VALUE;
        int low=Integer.MAX_VALUE;
        int n=bloomDay.length;
        if(n<(m*k)) return -1;
        int ans=-1;
        for(int i=0;i<n;i++){
            high=Math.max(high,bloomDay[i]);
        }
         for(int i=0;i<n;i++){
            low=Math.min(low,bloomDay[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(temp(mid,bloomDay,m,k)){
                ans=mid;
                high=mid-1;
            }else{
               low = mid+1;
            }
            
        }
        return ans;
    }
    static boolean temp(int mid,int[] bloomDay, int m, int k){
        int n=bloomDay.length;
        int length=0;
        int b=0;
        for(int i=0;i<n;i++){
            if(mid>=bloomDay[i]){
                length++;
                if(length==k){
                    b++;
                    length=0;
                }
            }else{
                length=0;
            }
            
            if(b>=m) return true;
        }
        return false;
    }
}