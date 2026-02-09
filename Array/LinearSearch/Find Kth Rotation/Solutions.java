class Solution {
    public int findKRotation(int arr[]) {
        // Code here
         int n=arr.length;
         int x=-1;
         for(int i=0;i<n-1;i++){
             if(arr[i]>arr[i+1]){
                 x=i;
                 break;
             }
         }
         return x+1;
    }
}
