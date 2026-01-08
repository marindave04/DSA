class Solution {
    static int[][] dp=new int[501][501];
    public int maxDotProduct(int[] nums1, int[] nums2) {
       for(int[] row:dp){
        Arrays.fill(row,-1000000000);
       }
        return solve(0,0,nums1,nums2);
    }
    static int solve (int i,int j,int[] nums1, int[] nums2){
        if(i==nums1.length || j==nums2.length) return -1000000000;
        if(dp[i][j]!=-1000000000) return dp[i][j];        
                                                                                          //actually p1 and p2 take hai aur p3 and p4 skip ki hum skip kaise kr skte hai 
        int p1=nums1[i]*nums2[j];
        int p2=nums1[i]*nums2[j]+solve(i+1,j+1,nums1,nums2);
        int p3=solve(i,j+1,nums1,nums2);
        int p4=solve(i+1,j,nums1,nums2);
        return dp[i][j]=Math.max(Math.max(p1,p2),Math.max(p3,p4));
    }
}