class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=low;i<=high;i++){
            if(!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
