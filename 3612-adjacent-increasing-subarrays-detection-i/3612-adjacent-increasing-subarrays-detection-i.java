class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
         int pv=0;
         int cur=1;
         for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                cur++;
               
            }else if(nums.get(i)<=nums.get(i-1)){
                pv=cur;
                cur=1;
                
            }
             if(cur/2>=k) return true;
                if(Math.min(pv,cur)>=k) return true;
         }
         return false;
    }
}