/*
| Approach                                                                                            | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Group same values → use prefix sums on indices to compute total distance for each index efficiently | **O(n)**        | **O(n)**         |

*/
class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] arr=new long[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
         HashMap<Integer,List<Integer>> map2=new HashMap<>();
         for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])>1){
                map2.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
            }
         }
         for(List<Integer> list:map2.values()){
             long[] psum1=new long[list.size()];
             psum1[0]=list.get(0);
             for(int i=1;i<list.size();i++){
                psum1[i]=(long)psum1[i-1]+list.get(i);
             }
             for(int i=0;i<list.size();i++){
               long value1=(long)i*list.get(i)- (i>0 ? psum1[i-1] : 0);
               long value2=(long)(psum1[list.size()-1]-psum1[i])-(long)(list.size()-i-1)*list.get(i);
               long value= value1+value2;
               arr[list.get(i)]=value;
             
             }
         }
         return arr;
    }
}
