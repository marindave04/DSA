class Solution {
    public int longestSubstring(String s, int k) {
        if(k>s.length()) return 0;
        if(s==null || s.isEmpty()) return 0;
       int[] freq=new int [26];
       int ans=0;
       for(int i=0;i<s.length();i++){
        Arrays.fill(freq,0);
        for(int j=i;j<s.length();j++){
           freq[s.charAt(j)-'a']++;
            if(check(s,i,j,k,freq)){
               int len=j-i+1;
               ans=Math.max(ans,len);
            }
        }
       }
       return ans;
    }
    static boolean check(String s,int i,int j,int k,int[]freq){
        int letterCount=0;
        int freqCount=0;
        for(int num:freq){
            if(num>0) letterCount++;
            if(num>=k) freqCount++;
        }
        return (letterCount==freqCount);
    }
}