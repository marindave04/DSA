class Solution {
    public String largestEven(String s) {
        while(s.length()>0&&s!=null && (s.charAt(s.length()-1)-'0')%2!=0){
            s=s.substring(0,s.length()-1);
        }
        return s;
    }
}