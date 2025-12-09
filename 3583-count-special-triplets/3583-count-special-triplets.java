class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        
        int mod=1000000007;
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int num:nums){
            map1.put(num,map1.getOrDefault(num,0)+1);
        }
        long count=0;
        for(int num:nums){
            int target=2*num;
            int leftCount=map2.getOrDefault(target,0);
            map2.put(num,map2.getOrDefault(num,0)+1);
            int rightCount=map1.getOrDefault(target,0)-map2.getOrDefault(target,0);
            count=(count+(long)leftCount*rightCount)%mod;
        }
        return (int)count;
    }
}