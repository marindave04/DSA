class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int previous=0;
        int current=1;
        int min=0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                current++;
                
            }else{
                previous=current;
                current=1;
            }
            min=Math.max(min,current/2);
            min= Math.max(min,Math.min(current,previous));
        }
        return min;
    }
}