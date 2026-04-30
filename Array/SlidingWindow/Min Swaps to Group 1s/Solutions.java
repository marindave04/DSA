/*| Approach                                                                                                                                                | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Count total `1`s, use sliding window of same size, track how many `1`s are inside each window; swaps needed = missing `1`s in that window, take minimum | **O(n)**        | **O(1)**         |


*/
class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int n=arr.length;
        int count1=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1) count1++;
        }
        if(count1==0) return -1;
        int i=0;
        int j=0;
        int count=0;
        int min=Integer.MAX_VALUE;
        while(j<n){
             if(arr[j]==1) count++;
            if(j-i+1<count1){
               j++;
            }else{
                min=Math.min(min,count1-count);
                if(arr[i]==1){
                    count--;
                }
                i++;
                j++;
            }
        }
        return min;
    }
}
