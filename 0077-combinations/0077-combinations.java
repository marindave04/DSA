class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        List<Integer> list=new ArrayList<>();
        solve(nums,0,k,list);
        return ans;
    }
    private void solve(int[] nums,int i,int k,List<Integer> list){
        if(i>=nums.length){
            if(list.size()==k){
              ans.add(new ArrayList<>(list));
              return;  
            }
            return;
        }
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(nums,i+1,k,list);
        list.remove(list.size()-1);
        solve(nums,i+1,k,list);
    }
}