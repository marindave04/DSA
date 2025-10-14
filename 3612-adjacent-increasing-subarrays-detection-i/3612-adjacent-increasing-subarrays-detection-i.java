class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
      // if(nums.size()==2 && k==1) return true;
        for(int i=0;i<nums.size();i++){
           if(nums.size()-i>=2*k) {
            boolean a=true;
            for(int j=i+1;j<i+k;j++){
                if(j<nums.size()&& nums.get(j-1)>=nums.get(j)){
                    a=false;
                    break;
                }
            }
            
            boolean b=true;
            for(int p=k+i+1;p<2*k+i;p++){
              if(p<nums.size() && nums.get(p-1)>=nums.get(p)){
                b=false;
                break;
              }
            }
            if(a==true && b==true) return true;
           }
           
            
            //if(a==true && b==true) return true;
        }
        return false;
    }
}