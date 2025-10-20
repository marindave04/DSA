class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        for(int p=0;p<n-2;p++){
            if (p > 0 && nums[p] == nums[p - 1]) continue;
            int target=0-nums[p];
            int i=p+1;
            int j=n-1;
           
            while(i<j){
              
                if(target<nums[i]+nums[j]){
                    j--;
                }else if(target>nums[i]+nums[j]){
                    i++;
                }else{
                     List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[p]);
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        list.add(triplet);
                        while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;
                       
                    i++;
                    j--;
                }
            }
        
        }
        return list;
    }
}