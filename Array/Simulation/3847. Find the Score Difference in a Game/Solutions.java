class Solution {
    public int scoreDifference(int[] nums) {
        boolean first=true;
        int count1=0;
        boolean second=false;
        int count2=0;
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                boolean temp=first;
                first=second;
                second=temp;   
            }
            if(i-idx+1==6){
                boolean temp2=first;
                first=second;
                second=temp2;
                idx=i+1;
            }
            if(first){
                count1=count1+nums[i];
            }
            if(second){
                count2=count2+nums[i];
            }
        }
        return count1-count2;
    }
}
