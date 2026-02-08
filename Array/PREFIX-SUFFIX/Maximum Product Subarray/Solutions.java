class Solution {
    int maxProduct(int[] arr) {
        // code here
        int prefix=1;
        int suffix=1;
        int n=arr.length;
        int i=0;
        int j=n-1;
        int max=Integer.MIN_VALUE;
        while(i<n && j>=0){
           // PREFIX
           if(arr[i]==0){
               max=Math.max(max,0);
               prefix=1;
           }else{
               prefix=prefix*arr[i];
               max=Math.max(max,prefix);
           }
           
           //suffix
           if(arr[j]==0){
                max=Math.max(max,0);
                suffix=1;
           }else{
               suffix=suffix*arr[j];
               max=Math.max(max,suffix);
           }
           i++;
           j--;
        }
        
        return max;
    }
}
