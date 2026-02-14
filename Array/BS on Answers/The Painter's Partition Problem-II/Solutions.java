class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low=Arrays.stream(arr).max().getAsInt();
        int high=Arrays.stream(arr).sum();
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,arr,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static boolean check(int mid,int[] arr,int k){
        int count=1;
        int curr=mid;
        for(int i=0;i<arr.length;i++){
            if(curr<arr[i]){
                count++;
                curr=mid;
            }
            if(count>k) return false;
            if(curr>=arr[i]){
                curr=curr-arr[i];
            }
        }
        return true;
    }
}
