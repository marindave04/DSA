/*| Approach                                                                                                                                    | Time           | Space                                |
| ------------------------------------------------------------------------------------------------------------------------------------------- | -------------- | ------------------------------------ |
| Count pairs with sum ≤ `upper` and subtract pairs with sum ≤ `lower - 1`. Each count is computed using sorting and a two-pointer technique. | **O(N log N)** | **O(1)** *(excluding sorting space)* |
*/
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
          long ans=countPairs(nums,upper)-countPairs(nums,lower-1);
          return ans;
    }
     static long countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int n=arr.length;
        int i=0;
        int j=n-1;
        long pair=0;
        while(i<j){
            if(arr[j]+arr[i]>target){
                j--;
            }else{
                pair+=(j-i);
                i++;
            }
        }
        return pair;
    }
}
