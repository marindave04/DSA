class Solution {
    public int countValidSelections(int[] nums) {
        //optimal
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        int currentSum=0;
        int leftSum=0;
        int rightSum=0;
        int result=0;
        for(int i=0;i<n;i++){
            currentSum +=nums[i];
            if(nums[i]==0){
                leftSum=currentSum-nums[i];
                rightSum=totalSum-leftSum;
                if(leftSum==rightSum){
                    result=result+2;
                }else if((int)Math.abs(leftSum-rightSum)==1){
                    result=result+1;
                }
            }
        }
        return result;
    }
}
