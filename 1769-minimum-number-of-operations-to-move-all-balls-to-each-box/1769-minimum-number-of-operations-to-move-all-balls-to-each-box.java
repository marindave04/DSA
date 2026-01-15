class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] ans=new int[n];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(boxes.charAt(j)=='1'){
                    ans[i]=ans[i]+Math.abs(j-i);
                }
            }
        }

        for(int i=n-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(boxes.charAt(j)=='1'){
                    ans[i]=ans[i]+Math.abs(j-i);
                }
            }
        }
        return ans;
    }
}