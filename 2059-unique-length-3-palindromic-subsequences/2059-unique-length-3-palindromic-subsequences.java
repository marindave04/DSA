class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> letter=new HashSet<>();
        for(Character c: s.toCharArray()){
            letter.add(c);
        }
        int res=0;
        for(Character ch:letter){
            int i=-1;
            int j=0;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k)==ch){
                    if(i==-1){
                        i=k;
                    }
                    j=k;
                }
            }
            Set<Character> between=new HashSet<>();
            for(int k=i+1;k<j;k++){
                between.add(s.charAt(k));
            }
            res+=between.size();
        }
        return res;
    }
}