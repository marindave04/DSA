class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int[] p=new int[n];//for preprocessing number of b before each index;
        int[] st=new int[n];//for preprocessing number of a after each index;
        if(s.charAt(0)=='b') p[0]=1;
        if(s.charAt(n-1)=='a') st[n-1]=1;
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            p[i]=p[i-1]+(ch=='b' ? 1 : 0);
        }

         for(int i=n-2;i>=0;i--){
            char ch=s.charAt(i);
            st[i]=st[i+1]+(ch=='a' ? 1 : 0);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int countb=(i>0 ? p[i-1] : 0);
            int counta=(i+1<n ? st[i+1]: 0);
            min=Math.min(min,counta+countb);
        }
        return min;
    }
}
