class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int[] pxor=new int[arr.length];
        pxor[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pxor[i]=pxor[i-1]^arr[i];
        }
        int i=0;
        int j=k-1;
        int max=0;
        while(j<arr.length){
           int xor=pxor[j]^(i>0 ? pxor[i-1] : 0);
           max=Math.max(max,xor);
           i++;
           j++;
        }
        return max;
    }
}
