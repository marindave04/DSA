class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
        solve(candidates,0,target,list);
        return ans;
    }
    private void solve(int[] candidates,int i,int target,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        for(int j=i;j<candidates.length;j++){
            list.add(candidates[j]);
            solve(candidates,j,target-candidates[j],list);
            
            list.remove(list.size()-1);
           
            
        }
    }
}