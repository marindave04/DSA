class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
      List<Integer> sub = new ArrayList<>();
      for (int x : nums) sub.add(x);
      
      solve(0,sub);
      return ans;
    }
   private void solve(int idx,List<Integer> list){
    if(idx==list.size()){
        ans.add(new ArrayList<>(list));
        return;
    }
    for(int i=idx;i<list.size();i++){
       Collections.swap(list, i, idx);
       solve(idx+1,list);
       Collections.swap(list, i, idx);
    }
   }
}