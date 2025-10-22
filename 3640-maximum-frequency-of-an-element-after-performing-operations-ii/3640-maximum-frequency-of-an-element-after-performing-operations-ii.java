class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(max,nums[i]);
        }
        TreeMap<Integer,Integer> diff=new TreeMap<>();
       for(int i=0;i<n;i++){
        int l=Math.max(0,nums[i]-k);
        int r=Math.min(nums[i]+k,max+k);
        diff.put(l,diff.getOrDefault(l,0)+1);
        diff.put(r+1,diff.getOrDefault(r+1,0)-1);
         diff.putIfAbsent(nums[i], diff.getOrDefault(nums[i], 0));
        
       }
       int ans=1;
       int cumSum=0;
       for(Map.Entry<Integer,Integer> entry:diff.entrySet()){
           int target=entry.getKey();
           int val=entry.getValue();
           cumSum=cumSum+val;
           int targetFreq = map.getOrDefault(target, 0);
           int reqop=cumSum-targetFreq;
           int totalFreq=Math.min(reqop,numOperations)+targetFreq;
           ans=Math.max(ans,totalFreq);
       }
       return ans;
    }
}