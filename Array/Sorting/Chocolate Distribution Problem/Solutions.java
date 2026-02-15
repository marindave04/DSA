// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
         Collections.sort(arr);
         int i=0;
         int j=m-1;
         int ans=Integer.MAX_VALUE;
         while(j<arr.size()){
             ans=Math.min(ans,arr.get(j)-arr.get(i));
             i++;
             j++;
         }
         return ans;
    }
}
