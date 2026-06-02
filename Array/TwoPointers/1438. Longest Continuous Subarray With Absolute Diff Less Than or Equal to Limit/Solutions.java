/*
| Approach                                                                                                                                          | Time           | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Use a sliding window with a `TreeMap` to maintain current minimum and maximum values, shrinking the window when their difference exceeds `limit`. | **O(N log N)** | **O(N)** |

*/
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int i=0;
        int j=0;
        int max=0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(Math.abs(map.firstKey()-map.lastKey())>limit){
                if(map.get(nums[i])==1){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i],map.get(nums[i])-1);
                }
                i++;
            }
            max=Math.max(max,j-i+1); 
            j++;
        }
       
        return max;
    }
}
