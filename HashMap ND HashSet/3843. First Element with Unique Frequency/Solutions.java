class Solution {
    public int firstUniqueFreq(int[] nums) {
      HashMap<Integer,Integer> map1=new HashMap<>();
      for(int a:nums){
        map1.put(a,map1.getOrDefault(a,0)+1);
      }
       HashMap<Integer,Integer> map2=new HashMap<>();
       for(int f:map1.values()){
         map2.put(f,map2.getOrDefault(f,0)+1);
       }
       for(int a:nums){
        if(map2.get(map1.get(a))==1) return a;
       }
       return -1;
    }
}
