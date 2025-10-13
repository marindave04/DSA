class Solution {
    public boolean isAnagram(String s, String t) {
       int[] a1=new int[26];
      // int[] a2=new int[26];
       for(char ch:s.toCharArray()){
        a1[ch-'a']++;
       }
       for(char ch:t.toCharArray()){
        a1[ch-'a']--;
       }
       for(int i=0;i<26;i++){
        if(a1[i]!=0) return false;
       }
       return true;
    }
}