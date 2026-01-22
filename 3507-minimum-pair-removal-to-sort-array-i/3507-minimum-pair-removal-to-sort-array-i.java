class Solution {
    public int minimumPairRemoval(int[] nums) {
       int[] prev=nums;
       int op=0;
       if(sort(prev)) return op;
       boolean flag=true;
       while(flag){
        int prevSum=Integer.MAX_VALUE;
        int currSum=0;
        int idx=0;
        for(int i=0;i<prev.length-1;i++){
            currSum=prev[i]+prev[i+1];
            if(currSum<prevSum){
                idx=i;
                prevSum=currSum;
            }
        }
        int[] curr=new int[prev.length-1];
        curr[idx]=prevSum;
        for(int k=0;k<idx;k++){
            curr[k]=prev[k];
        }
        int p=idx+1;
        for(int k=idx+2;k<prev.length;k++){
            curr[p++]=prev[k];
        }
        prev=curr;
        if(sort(curr)){
            flag=false;
        }
        op++;
       }
       return op;
    }
    static boolean sort(int[] arr){
        boolean flag = true;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return flag;
    }
}