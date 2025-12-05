class Solution {
    public int countPartitions(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2==0) return nums.length-1;
        return 0;
    }
}