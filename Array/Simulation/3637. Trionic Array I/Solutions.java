class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        boolean flag1=false;
        int p=-1;
        for(int i=0;i<n-1;i++){
           if(nums[i]<nums[i+1]){
            p=i+1;
             flag1=true;
           }else{
            break;
           }
        }
        if(p==-1) return false;
        if(p>=n-2) return false;
        boolean flag2=false;
        int q=p;
        for(int i=p;i<n-1;i++){
             if(nums[i]>nums[i+1]){
                q=i+1;
                flag2=true;
             }else{
                break;
             }
        }
        boolean flag3=false;
        if(q>=n-1) return false;
        int r=q;
        for(int i=q;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                r=i+1;
                flag3=true;
            }else {
                break;
            }
        }
    if(r<n-1) flag3=false;
        return (flag1 && flag2 && flag3);
    }
}
