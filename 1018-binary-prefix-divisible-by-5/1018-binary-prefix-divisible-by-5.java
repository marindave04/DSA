class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n=nums.length;
        List<Boolean>list=new ArrayList<>();
        int curr=0;
        for(int i=0;i<n;i++){
        
          //  curr=curr*2;
            curr=(curr*2+nums[i])%5;
            if(curr==0){
                list.add(true);
            }else{
                list.add(false);
            }
        
        }
        return list;
    }
}