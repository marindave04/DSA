class Solution {
    public int countPermutations(int[] complexity) {
        int mod=1000000007;
        int n=complexity.length;
        int T=complexity[0];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<complexity.length;i++){
            min=Math.min(min,complexity[i]);
        }
        if(min<=T) return 0;
        long count=1;
        for(int i=2;i<n;i++){
            count=((long)count*i)%mod;
        }
        return (int) count;
    }
}