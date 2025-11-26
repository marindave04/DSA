class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
         List<List<Integer>> ans=new ArrayList<>();
         List<Integer> subset=new ArrayList<>();
         solve(nums,0,subset,ans);
         return ans;
    }
    static void solve(int[] nums,int i, List<Integer> subset,List<List<Integer>> ans){
        if(i>=nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        solve(nums,i+1,subset,ans);
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        solve(nums,i+1,subset,ans);
    }
}