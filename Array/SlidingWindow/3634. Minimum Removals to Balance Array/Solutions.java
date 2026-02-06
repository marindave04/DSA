class Solution {
    public int minRemoval(int[] nums, int k) {
    Arrays.sort(nums);
      int n=nums.length;
      int max=0;
      int i=0;
      int j=0;
      while(j<n){
       
        if((long)nums[j]<=(long)k*nums[i]){
            max=Math.max(max,j-i+1);
            j++;
        }else{
            i++;
        }
      }  
      return n-max;
    }
}
