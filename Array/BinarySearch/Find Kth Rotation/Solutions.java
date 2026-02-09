class Solution {
    public int findKRotation(int arr[]) {
        // Code here
         int n=arr.length;
         int s=0;
         int e=n-1;
         while(s<=e){
             int m=s+(e-s)/2;
             if(arr[s] <= arr[m] && arr[e]>=arr[m]) return 0;
             if(arr[s]>arr[m]){
                 if(arr[m]<arr[m-1]){
                     return m;
                 }else{
                     e=m-1;
                 }
             }else if(arr[e]<arr[m]){
                 if(arr[m]>arr[m+1]){
                     return m+1;
                 }else{
                     s=m+1;
                 }
             }
         }
         return 0;
    }
}
