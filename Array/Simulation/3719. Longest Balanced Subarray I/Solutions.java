class Solution {
    public int longestBalanced(int[] nums) {
       int n=nums.length;
       int max=0;
       for(int i=0;i<n;i++){
        int co=0;
        int ce=0;
        HashSet<Integer> set=new HashSet<>();
        for(int j=i;j<n;j++){
            if(!set.contains(nums[j]) && nums[j]%2==0){
                ce++;
                set.add(nums[j]);
            }else if(!set.contains(nums[j]) && nums[j]%2!=0){
                co++;
                set.add(nums[j]);

            }
            if(co==ce){
                max=Math.max(max,j-i+1);
            }
        }
       } 
       return max;
    }
}
