class Solution {
     private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
      Arrays.sort(nums);
      boolean[] temp=new boolean[nums.length];
      List<Integer> list=new ArrayList<>();
      solve(nums,temp,list);
      return ans;
    }
     private void solve(int[] nums,boolean[] temp,List<Integer> list){
    if(list.size()==nums.length){
        ans.add(new ArrayList<>(list));
    }
    for(int i=0;i<nums.length;i++){
       if(i>0 && nums[i]==nums[i-1] && temp[i-1]==false) continue;
        if(!temp[i]){
            list.add(nums[i]);
            temp[i]=true;
            solve(nums,temp,list);
            list.remove(list.size()-1);
            temp[i]=false;
        }
        
    }
   }
}