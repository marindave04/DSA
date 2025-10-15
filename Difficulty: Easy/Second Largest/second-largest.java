class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max1=arr[0];
        for(int i=0;i<arr.length;i++){
            max1=Math.max(max1,arr[i]);
        }
        int max2=0;
        int diff=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max1) continue;
             if(arr[i]>max2 && arr[i]<max1){
                 max2=arr[i];
             }
            
             
        }
        if(max2==0) return -1;
        return max2;
    }
}