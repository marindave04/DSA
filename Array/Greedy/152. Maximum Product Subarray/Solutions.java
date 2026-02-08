class Solution {
    public int maxProduct(int[] nums) {
        // lets just solve it greedily

        int n=nums.length;
        int currMax=nums[0];
        int currMin=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++){

            // is index tak currmax kya hoga
            int temp= Math.max(nums[i],Math.max(nums[i]*currMax,nums[i]*currMin));
            currMin= Math.min(nums[i],Math.min(nums[i]*currMax,nums[i]*currMin));
            currMax=temp;
            max=Math.max(max,temp);
        }
        return max;
    }
}
