/*
| Approach                                                         | Time Complexity | Space Complexity |
| ---------------------------------------------------------------- | --------------- | ---------------- |
| **HashMap + Index List + Sliding Window (Triplet Optimization)** | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int minimumDistance(int[] nums) {
         HashMap<Integer,Integer> map=new HashMap<>();
       for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
       }
      
       HashMap<Integer,List<Integer>> map2=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        if(map.get(nums[i])>=3){
            map2.putIfAbsent(nums[i],new ArrayList<>());
            map2.get(nums[i]).add(i);
        }
       }
       int min=Integer.MAX_VALUE;
       for(int key:map2.keySet()){
       List<Integer> list=map2.get(key);
       int x=list.get(0);
       int y=list.get(1);
       int z=list.get(2);
       int j=2;
       int sum=0;
       while(j<list.size()){
             sum=(int)Math.abs(x-y)+(int)Math.abs(y-z)+(int)Math.abs(z-x);
            min=Math.min(min,sum);
            if(j>=3){
                x=y;
                y=z;
                z=list.get(j);
                 sum=(int)Math.abs(x-y)+(int)Math.abs(y-z)+(int)Math.abs(z-x);
            min=Math.min(min,sum);
            }
            j++;
       }
       }
       
       return min==Integer.MAX_VALUE ? -1 : min;
    }
}
