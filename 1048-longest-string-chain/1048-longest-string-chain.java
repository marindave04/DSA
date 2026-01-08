class Solution {
    public int longestStrChain(String[] words) {
      int[] t=new int[1001];
      Arrays.fill(t,1);
      Arrays.sort(words,(a,b)->a.length()-b.length());
      int maxLis=1;
      for(int i=0;i<words.length;i++){
        for(int j=0;j<i;j++){
            if(valid(words[j],words[i])){
                t[i]=Math.max(t[i],t[j]+1);
                maxLis=Math.max(maxLis,t[i]);
            }
        }
      }
   
   return maxLis;
      
    }
    
    static boolean valid(String s1, String s2) {
    if (s2.length() != s1.length() + 1) return false;

    int i = 0, j = 0;
    boolean skipped = false;

    while (i < s1.length() && j < s2.length()) {
        if (s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        } else {
            if (skipped) return false;
            skipped = true;
            j++; // extra character in s2
        }
    }
    return true;
}

}