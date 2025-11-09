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
            List<Integer> indices=entry.getValue();
            for(int i=0;i<indices.size()-2;i++){
                int temp=0;
                for(int j=i;j<indices.size();j++){
                    if(j-i+1==3){
                        temp=2*(indices.get(j)-indices.get(i));
                    }
                }
                min=Math.min(min,temp);
            }
            
        }
         if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
}