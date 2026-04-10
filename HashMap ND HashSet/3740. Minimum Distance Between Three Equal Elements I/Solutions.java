/*
| Approach                                                | Time Complexity | Space Complexity |
| ------------------------------------------------------- | --------------- | ---------------- |
| **HashMap + Index Collection + Sliding Triplets Check** | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int minimumDistance(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
       }
       Map<Integer,int[]> map2=new HashMap<>();
       for(int key:map.keySet()){
        int n=map.get(key);
        if(n>=3){
            int[] list=new int[n];
            int idx=0;
           for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
              list[idx++]=i;
               
            }
           }
           map2.put(key,list);
        }
       }
       int min=Integer.MAX_VALUE;
       for(int key:map2.keySet()){
        int[] temp=map2.get(key);
        int n=temp.length;
        for(int i=0;i<=n-3;i++){
            int x=temp[i];
            int y=temp[i+1];
            int z=temp[i+2];
            int sum=(int)Math.abs(x-y)+(int)Math.abs(y-z)+(int)Math.abs(z-x);
            min=Math.min(min,sum);
        }
       }
       return min==Integer.MAX_VALUE ? -1 : min;
    }
}
