class Solution {
    public boolean hasSameDigits(String s) {
       
        while(s.length()>2){
            String newStr = "";
            for(int i=0;i<s.length()-1;i++){
                int a=s.charAt(i)-'0';
                int b=s.charAt(i+1)-'0';
                int sum=(a+b)%10;
                newStr=newStr+sum;
            }
            s=newStr;
        }
        if(s.charAt(0)==s.charAt(1)) return true;
        return false;
    }
}