class Solution {
    public int minPairSum(int[] nums) {
       Arrays.sort(nums);
       int i=0;
       int j=nums.length-1;
       int sum=0;
       while(j>i){
        sum=Math.max(sum,nums[i]+nums[j]);
        i++;
        j--;
       } 
       return sum;
    }
}