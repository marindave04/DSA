class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        int prev=Integer.MIN_VALUE;
        int temp=nums[n-1]+k;
        for(int i=0;i<n;i++){
           int l=Math.max(nums[i]-k,prev+1);
           if(l<=nums[i]+k){
            prev=l;
            count++;
           }
        }
        return count;
    }
}