class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int[] p=new int[n];
        p[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            p[i]=p[i+1]+nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            int sum=p[i+1];
            int num=n-i-1;
            int avg=sum/num;
            if(nums[i]>avg) count++;
        }
        return count;
    }
}
