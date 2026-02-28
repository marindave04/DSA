class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        Map<Character,Character> map1=new HashMap<>();
         Map<Character,Character> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(map1.containsKey(ch1)){
                if(map1.get(ch1)!=ch2) return false;
            }else{
                map1.put(ch1,ch2);
            }
        }
        for(int i=0;i<s1.length();i++){
            char ch1=s2.charAt(i);
            char ch2=s1.charAt(i);
            if(map2.containsKey(ch1)){
                if(map2.get(ch1)!=ch2) return false;
            }else{
                map2.put(ch1,ch2);
            }
        }
        return true;
    }
}
