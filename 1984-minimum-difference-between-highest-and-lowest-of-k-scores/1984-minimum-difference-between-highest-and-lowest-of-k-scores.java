class Solution {
    public int minimumDifference(int[] nums, int k) {
      Arrays.sort(nums);
      int n=nums.length;
      int i=n-1;
      int j=n-1;
      int min=Integer.MAX_VALUE;
      while(j>=0){
        if(i-j+1==k){
            min=Math.min(min, nums[i]-nums[j]) ;
            i--;
        }
        j--;
      } 
      return min; 
    }
}