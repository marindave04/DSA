class Solution {
     private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
     
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
     HashSet<Integer> used = new HashSet<>();
    for(int i=idx;i<list.size();i++){
        if (used.contains(list.get(i))) continue;
            used.add(list.get(i));

       Collections.swap(list, i, idx);
       solve(idx+1,list);
       Collections.swap(list, i, idx);
    }
   }
}