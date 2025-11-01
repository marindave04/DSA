class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length-2;
        
        int xorOfTwoNumber=0;
        for(int i=0;i<nums.length;i++){
            xorOfTwoNumber^=nums[i];
        }
        for(int i=0;i<n;i++){
            xorOfTwoNumber^=i;
        }
        int firstBitDiff=xorOfTwoNumber & -xorOfTwoNumber;
        int g1=0;
        int g2=0;
        for(int i=0;i<nums.length;i++){
            if((firstBitDiff & nums[i])==0){
                g1^=nums[i];
            }else{
                g2^=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if((firstBitDiff & i)==0){
                g1^=i;
            }else{
                g2^=i;
            }
        }
        return new int[] {g1,g2};
    }
}