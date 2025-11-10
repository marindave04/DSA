class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static boolean check(int[] nums,int capacity,int days){
        int sum=Arrays.stream(nums).sum();
        int temp=0;
        int required=1;
        for(int i=0;i<nums.length;i++){
            sum=sum-nums[i];
            temp+=nums[i];
            if(temp>capacity){
                temp=nums[i];
                required=required+1;
            }
            // if(temp>capacity)
        }
        if(sum==0&&required<=days) return true;
        return false;
    }
}