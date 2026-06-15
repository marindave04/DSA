/*
| Approach                                                                                                                                                                               | Time           | Space    |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Convert each number into an interval `[nums[i]-k, nums[i]+k]`, create start/end events, sort them, and use a sweep-line algorithm to find the maximum number of overlapping intervals. | **O(N log N)** | **O(N)** |

*/
class Solution {
    public int maximumBeauty(int[] nums, int k) {
         int n=nums.length;
         ArrayList<int[]> pairs=new ArrayList<>();
         for(int i=0;i<n;i++){
             pairs.add(new int[]{nums[i]-k,0});
              pairs.add(new int[]{nums[i]+k,1});
         }
         pairs.sort((a,b)->{
         if(a[0]!=b[0]){
             return Integer.compare(a[0],b[0]);
         }
          return Integer.compare(a[1],b[1]);
        });
         int c=0;
         int max=0;
         for(int i=0;i<pairs.size();i++){
             int first=pairs.get(i)[0];
             int second=pairs.get(i)[1];
             if(second==0){
                 c++;
                 max=Math.max(max,c);
             }else{
                 max=Math.max(max,c);
                 c--;
             }
         }
         return max;
    }
}
