class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<4) return false;
        //we will define three states 0-inc,1-dec,2-inc
        //initially hum 0 state me honge
        int state=0;
        // hum flag bhi maintain krenge ye check krne ke liye ki jb hum ek state se dusre state transition krenge toh wo transition valid hona chahiye
        boolean inc1=false;
        boolean inc2=false;
        boolean dec=false;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]) return false;
            if(state==0){
                if(nums[i]<nums[i+1]){
                    inc1=true;
                }else{
                    if(!inc1) return false;
                    state=1;
                    dec=true;
                }
            }else if(state==1){
                if(nums[i]>nums[i+1]){
                    dec=true;
                }else{
                    state=2;
                    inc2=true;
                }
            }else{
                if(nums[i]<nums[i+1]){
                    inc2=true;
                   
                }else{
                    return false;
                }
            }
        }
        return (inc1 && dec && inc2)&&(state==2);
    }
}
