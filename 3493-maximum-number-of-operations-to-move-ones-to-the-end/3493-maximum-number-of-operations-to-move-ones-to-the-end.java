class Solution {
    public int maxOperations(String s) {
       int op=0;
       int count1=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='1'){
            count1++;
        }else if(s.charAt(i)=='0'){
           if(i>0 && s.charAt(i)!=s.charAt(i-1)){
            op+=count1;
           }
        }
       }
       return op;
    }
}