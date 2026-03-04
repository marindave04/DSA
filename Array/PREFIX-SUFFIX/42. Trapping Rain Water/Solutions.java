class Solution {
    public int trap(int[] arr) {
         // code here
        int ans=0;
        //we will precalculate the max height left to index i and max height right to index i
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        left[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        right[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }
        for(int i=1;i<arr.length-1;i++){
            
           
            int height=Math.min(left[i],right[i])-arr[i];
            int water=height*1;
            ans+=water;
        }
        return ans;
    }
}
