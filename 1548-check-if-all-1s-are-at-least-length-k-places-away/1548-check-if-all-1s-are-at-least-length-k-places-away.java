class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        boolean temp=false;
        int count1=0;
        for(int p=0;p<n;p++){
            if(nums[p]==1) count1++;
        }
        if(count1==1) return true;
        if(count1==0) return true;
       // if (nums[i]!=1)return false;
        while(j<n){
            if(nums[i]==0 && nums[j]==0){
                i++;
                j++;
            }else if((nums[i]==1 && nums[j]==1) && (i==j)){
                j++;
            }else if(nums[i]==1 && nums[j]==0){
                j++;
            
            }else if(nums[i]==1 && nums[j]==1){
                int dist=j-i-1;
                if(dist>=k){
                    temp=true;
                }else{
                    return false;
                }
                i=j;
            }
        }
        return temp;
    }
}