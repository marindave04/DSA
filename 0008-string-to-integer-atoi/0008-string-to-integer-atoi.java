class Solution {
    public int myAtoi(String s) {
        //checking if string is null or not
        if(s==null || s.length()==0){
            return 0;
        }
       final int max=Integer.MAX_VALUE;
       final int min=Integer.MIN_VALUE;
        int i=0;
        int n=s.length();
        //checking for white spaces
        while(i<n && s.charAt(i)==' '){
            i++;
        }
         //check if we have reached at the end
         if(i==n) return 0;
         //check for sign
         int sign=1;
         if(s.charAt(i)=='+'){
            i++;
         }else if(s.charAt(i)=='-'){
            sign=-1;
            i++;
         }
         //read the digit and convert
         long res=0;
         while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i) - '0';
            res=res*10+digit;
            if(res*sign<=min) return min;
            if(res*sign>=max) return max;
            i++;
         }
         return (int)(res*sign);
    }
}