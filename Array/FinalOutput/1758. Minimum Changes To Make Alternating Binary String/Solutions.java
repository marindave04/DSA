//Approach 1: Start with Zero or Start with One
class Solution {
    public int minOperations(String s) {
      int s0=0;
      int s1=0;
      for(int i=0;i<s.length();i++){
        if(i%2==0){
            if(s.charAt(i)=='0'){
                s1++;
            }else{
                s0++;
            }
        }else{
            if(s.charAt(i)=='0'){
                s0++;
            }else{
                s1++;
            }
        }
      }
      return Math.min(s0,s1);
    }
}
//Approach 2: Only Check One
class Solution {
    public int minOperations(String s) {
      int s0=0;
      
      for(int i=0;i<s.length();i++){
        if(i%2==0){
            if(s.charAt(i)!='0') s0++;
        }else{
            if(s.charAt(i)!='1') s0++;
        }
          
      }
      
      return Math.min(s0,s.length()-s0);
    }
}
