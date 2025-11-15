class Solution {
    public char findKthBit(int n, int k) {
        return solve("0",1,n,k);
    }
    static char solve(String str,int i,int n,int k){
        if(str.length()>k){
            return str.charAt(k-1);
        }
        str=str+"1" + reverse(invert(str));
        return solve(str,i+1,n,k);
    }
    static String invert(String str ){
        StringBuilder sb=new StringBuilder();
        for(char ch:str.toCharArray()){
          sb.append(ch=='0' ? '1': '0');
        }
        return sb.toString();
    }
   static String reverse(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i = s.length() - 1; i >= 0; i--) {
        sb.append(s.charAt(i));
    }
    return sb.toString();
}
}