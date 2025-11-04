class Solution {
    public int longestSubstring(String s, int k) {
       return sub(s,0,s.length(),k);
    }
    static int sub(String s,int start,int e,int k){
        if(e-start < k){
            return 0;
        }
        int[] fq=new int[26];
        for(int i=start;i<e;i++){
            char ch=s.charAt(i);
            fq[ch-'a']++;
        }
        for(int j=start;j<e;j++){
            if(fq[s.charAt(j)-'a'] < k){
                int next=j+1;
                while(next<e && fq[s.charAt(next)-'a'] < k) next++;
                int left=sub(s,start,j,k);
                int right=sub(s,next,e,k);
                 return Math.max(left,right);
            }
        }
        return e-start;
    }
}