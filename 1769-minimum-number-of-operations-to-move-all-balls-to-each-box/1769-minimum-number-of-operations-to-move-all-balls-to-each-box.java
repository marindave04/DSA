class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] ans=new int[n];
        int[] cumSumFromRight=new int[n];
        cumSumFromRight[n-1]=boxes.charAt(n-1)-'0';
        for(int i=n-2;i>=0;i--){
            cumSumFromRight[i]=cumSumFromRight[i+1]+boxes.charAt(i)-'0';
        }
       int[] p1=new int[n];
       p1[0]=cumSumFromRight[0];
       for(int i=1;i<n;i++){
        p1[i]=p1[i-1]+cumSumFromRight[i];
       }
       //now traversing from left to right to fill ans using p1
       for(int i=0;i<n-1;i++){
        ans[i]=p1[n-1]-p1[i];
       }
       //now next step we will do same from left
        int[] cumSumFromLeft=new int[n];
        cumSumFromRight[0]=boxes.charAt(0)-'0';
        for(int i=1;i<n;i++){
            cumSumFromRight[i]=cumSumFromRight[i-1]+boxes.charAt(i)-'0';
        }
        int[] p2=new int[n];
        p2[n-1]=cumSumFromRight[n-1];
         for(int i=n-2;i>=0;i--){
        p2[i]=p2[i+1]+cumSumFromRight[i];
       }
       //now again we will be filling ans using p2 dir will be from right to left
       for(int i=n-1;i>0;i--){
        ans[i]=ans[i]+p2[0]-p2[i];
       }
       return ans;
    }
}