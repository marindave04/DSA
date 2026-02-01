class Solution {
    public int minimumCost(int[] nums) {
        if(sorted(nums)) return nums[0]+nums[1]+nums[2];
        int cost=nums[0];
        Arrays.sort(nums,1,nums.length);
        return cost+nums[1]+nums[2];
    }
    boolean sorted(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) return false;

        }
        return true;
    }
}
