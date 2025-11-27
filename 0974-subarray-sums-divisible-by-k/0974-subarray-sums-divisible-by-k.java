class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            int r=(sum)%k;
            if(r<0){
                r=r+k;
            }
            if(map.containsKey(r)){
                count+=map.get(r);
            }
            
            
                 map.put(r,map.getOrDefault(r,0)+1);
            
        }
        return count;
    }
}