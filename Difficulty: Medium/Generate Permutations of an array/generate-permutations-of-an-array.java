class Solution {
    public static ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ans.clear();
        boolean[] used=new boolean[arr.length];
        solve(arr,new ArrayList<>(),used);
        return ans;
    }
    static void solve(int[] nums,ArrayList<Integer> list, boolean[] used){
        if(list.size()>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                list.add(nums[i]);
                used[i]=true;
                solve(nums,list,used);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
    }
};