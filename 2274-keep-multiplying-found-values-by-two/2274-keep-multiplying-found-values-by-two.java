class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%original==0){
                map.put(nums[i],0);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(original)){
                original *=2;
            }
        }
        return original;
    }
}