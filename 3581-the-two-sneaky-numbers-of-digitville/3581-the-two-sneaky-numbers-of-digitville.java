class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans= new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n=nums.length-2;
        int index=0;
        for(int i=0;i<=n;i++){
            if(map.containsKey(i) && map.get(i)==2){
               ans[index++]=i;
            }
        }
        return ans;
    }
}