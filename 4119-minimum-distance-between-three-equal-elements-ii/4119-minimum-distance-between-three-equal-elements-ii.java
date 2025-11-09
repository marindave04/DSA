class Solution {
    public int minimumDistance(int[] nums) {
          HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        
        }
        
       // int temp=0;
        HashMap<Integer,List<Integer>> map2=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])>=3){
               map2.putIfAbsent(nums[i],new ArrayList<>());
               map2.get(nums[i]).add(i);
            }
            
        }
        for(Map.Entry<Integer,List<Integer>> entry:map2.entrySet()){
            //int element=entry.getKey;
            List<Integer> tuple=entry.getValue();
            for(int i=0;i<tuple.size()-2;i++){
                int t1 = tuple.get(i);
                int t2 = tuple.get(i + 1);
                int t3 = tuple.get(i + 2);

                int distance = Math.abs(t1 - t2) + Math.abs(t2 - t3) + Math.abs(t1 - t3);
                min = Math.min(min, distance);
            }
            
        }
         if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
}