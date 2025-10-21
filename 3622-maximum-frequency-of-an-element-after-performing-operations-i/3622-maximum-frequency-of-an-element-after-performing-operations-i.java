class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int[] cum=new int[max+k+1];
        for(int i=0;i<nums.length;i++){
             cum[nums[i]]++;
        }
        for(int i=1;i<cum.length;i++){
            cum[i]=cum[i]+cum[i-1];
        }
        int temp=0;
        for(int target=0;target<=max;target++){
            //if(cum[target]==0) continue;
            int l=Math.max(0,target-k);
            int r=Math.min(target+k,cum.length-1);
            int totalcount=cum[r]-(l>0 ?cum[l-1] : 0);
            int targetcount=cum[target]-(target>0 ? cum[target-1]:0);
            int reqop=totalcount-targetcount;
            int freq=targetcount+Math.min(reqop,numOperations);
            temp=Math.max(temp,freq);
        }
        return temp;
    }
}