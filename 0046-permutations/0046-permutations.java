class Solution {
     private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        solve(nums,list,used);
        return ans;
    }
    private void solve(int[] nums, List<Integer> list, boolean[] used){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j=0;j<nums.length;j++){
            if(!used[j]){
                used[j]=true;
            list.add(nums[j]);
            solve(nums,list,used);
            list.remove(list.size()-1);
            used[j]=false;
            }
        }
    }
}