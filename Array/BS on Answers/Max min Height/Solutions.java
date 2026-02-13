// without DAT
class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int low = Arrays.stream(arr).min().getAsInt();
        int high=low+k;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(check(arr,mid,k,w)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    static boolean check(int[] nums,int mid,int k,int w){
        int[] temp=nums.clone();
        int totalDaysUsed=0;
        int need=0;
        for(int i=0;i<nums.length;i++){
            
           if(temp[i]<mid){
               // watering is necessar
               need=mid-temp[i];
               totalDaysUsed +=need;
               if(totalDaysUsed>k) return false;
               for(int j=i;j<i+w && j<nums.length;j++){
                   temp[j]+=need;
               }
           }
        }
        return true;
    }
}
//WITH DAT
class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int low = Arrays.stream(arr).min().getAsInt();
        int high=low+k;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(check(arr,mid,k,w)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    static boolean check(int[] nums,int mid,int k,int w){
       int n=nums.length;
       int[] diff=new int[n+1];
       int curr=0;
       int Day=0;
       for(int i=0;i<n;i++){
           curr+=diff[i];
           int currHeight= nums[i]+curr;
           if(currHeight<mid){
               int need=mid-currHeight;
               diff[i]+=need;
                Day+=need;
               if(Day>k) return false;
               curr+=need;
               if(i+w<diff.length){
                   diff[i+w]-=need;
               }
           }
       }
       return true;
    }
}
