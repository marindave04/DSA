class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        int prev=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int min=nums[i]-k;
            if(prev<min){
                prev=min;
                count++;
            }else if(prev<nums[i]+k){
                prev=prev+1;
                count++;
            }
        }
        return count;
    }
}