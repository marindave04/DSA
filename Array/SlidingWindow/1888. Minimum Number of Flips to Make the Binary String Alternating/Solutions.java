class Solution {
    public int minFlips(String s) {
       int n=s.length();
       s=s+s;
       //generating final string
         StringBuilder s1=new StringBuilder();
         StringBuilder s2=new StringBuilder();

      for(int i=0;i<2*n;i++){
        if(i%2==0){
           s1.append('0');
           s2.append('1');
         }else{
        s1.append('1');
        s2.append('0');
       }
      }

       String str1=s1.toString();
       String str2=s2.toString();
       int i=0;
       int j=0;
       int res=Integer.MAX_VALUE;
       int f1=0;
       int f2=0;
       while(j<s.length()){
          if((j-i+1)<=n){
            if(s.charAt(j)!=s1.charAt(j)) f1++;
            if(s.charAt(j)!=s2.charAt(j)) f2++;
            j++;
          }else{
            res=Math.min(res,Math.min(f1,f2));
            if(s.charAt(i)!=s1.charAt(i)) f1--;
             if(s.charAt(i)!=s2.charAt(i)) f2--;
            i++;
          }
       }
       return res;
    }
}
