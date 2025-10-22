class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(max,nums[i]);
        }
       int[] diff=new int[max+k+2];
       for(int i=0;i<n;i++){
        int l=Math.max(0,nums[i]-k);
        int r=Math.min(nums[i]+k,diff.length-1);
        diff[l]++;
        diff[r+1]--;
       }
       int ans=1;
       for(int target=0; target<=max+k;target++ ){
           diff[target] +=(target>0 ? diff[target-1] : 0);
           int targetFreq = map.getOrDefault(target, 0);
           int reqop=diff[target]-targetFreq;
           int totalFreq=Math.min(reqop,numOperations)+targetFreq;
           ans=Math.max(ans,totalFreq);
       }
       return ans;
    }
}