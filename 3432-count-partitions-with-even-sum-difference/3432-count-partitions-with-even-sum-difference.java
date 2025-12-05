class Solution {
    public int countPartitions(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        int sum1=0;
        int sum2=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            sum1=sum1+nums[i];
            sum2=sum-sum1;
            if((sum1-sum2)%2==0) count++;
        }
        return count;
    }
}