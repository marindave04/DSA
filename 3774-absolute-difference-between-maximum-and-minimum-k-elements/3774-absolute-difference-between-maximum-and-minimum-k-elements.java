class Solution {
    public int absDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int sum1=0;
        for(int i=0;i<k;i++){
           sum1=sum1+nums[n-1-i];
        }
        int sum2=0;
        for(int i=0;i<k;i++){
            sum2=sum2+nums[i];
        }
        return (int)Math.abs(sum1-sum2);
    }
}