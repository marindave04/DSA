class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int result=0;
        if(k==0) return nums.length;
        for(int i=0;i<nums.length;){
            int j=i;
           while(j<nums.length && nums[i]==nums[j]){
                j++;
            }
            int freq=j-i;
            if((nums.length-j)>=k){
                result=result+freq;
            }
            i=j;
        }
        return result;
    }
}