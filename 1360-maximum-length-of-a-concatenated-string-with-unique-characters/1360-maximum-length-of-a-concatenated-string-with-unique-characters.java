class Solution {
    public int maxLength(List<String> arr) {
        return length(arr,0,"");

    }
    static int length(List<String> arr,int i,String str){
        if(i>=arr.size()){
            if(isUnique(str)){
                return str.length();
            }
            return 0;
        }
            int skip=length(arr,i+1,str);
            str+=arr.get(i);
            int choose=length(arr,i+1,str);

            return Math.max(skip,choose);
    }
     static boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false; // duplicate found
            }
            set.add(c);
        }
        return true; // all unique
}
}