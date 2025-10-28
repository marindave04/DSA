class Solution {
    //  List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //ans.clear();
        List<Integer>list=new ArrayList<>();
        subset(nums,0,list);
        return ans;
    }
    private List<List<Integer>> ans=new ArrayList<>();
    private void subset(int[] nums,int i,List<Integer> list){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
         list.add(nums[i]);
        subset(nums,i+1,list);
        list.remove(list.size()-1);
        subset(nums,i+1,list);
        
    }
}