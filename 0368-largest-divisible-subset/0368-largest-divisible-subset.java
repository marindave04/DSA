class Solution {
   
    public List<Integer> largestDivisibleSubset(int[] nums) {
       Arrays.sort(nums);
       int n=nums.length;
       int[] t=new int[n];
       Arrays.fill(t,1);
       int[] prevIndex = new int[n];
       Arrays.fill(prevIndex,-1);
       int lastIndex=0;
       int maxL=1;
       for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            if(nums[i]%nums[j]==0){
                if(t[i]<t[j]+1){
                    t[i]=t[j]+1;
                    prevIndex[i]=j;
                }
             if(t[i]>maxL){
                maxL=t[i];
                lastIndex=i;
             }
            }
        }
       }
       ArrayList<Integer> result = new ArrayList<>();
       int k=lastIndex;
       while(k!=-1){

        result.add(nums[k]);
        k=prevIndex[k];
       }
     Collections.reverse(result);
     return result;
    }
}