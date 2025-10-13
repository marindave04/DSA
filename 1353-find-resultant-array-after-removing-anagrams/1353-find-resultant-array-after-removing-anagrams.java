class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> list=new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(!isAnagram(words[i],list.get(list.size()-1))){
                list.add(words[i]);
            }
        }
        return list;
    }
     public static boolean isAnagram(String s, String t) {
       int[] a1=new int[26];
     
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