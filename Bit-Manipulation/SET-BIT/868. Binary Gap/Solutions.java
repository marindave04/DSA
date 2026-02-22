//BRUTE FORCE -> TC-O(N);
class Solution {
    public int binaryGap(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n=n/2;
        }
        sb.reverse();
        String str=sb.toString();
        int i=0;
        int j=1;
        int max=0;
        while(j<str.length()){
            char ch=str.charAt(j);
            if(ch=='0'){
                j++;
            }else{
                max=Math.max(max,j-i);
                i=j;
                j++;
            }
        }
        return max;
    }
}
//OPTIMAL APPROACH-1
class Solution {
    public int binaryGap(int n) {
      int curr=0;
      int prev=-1;
      int max=0;
      while(n>0){
        if((n&1)>0){
            if(prev>=0){
                max=Math.max(max,curr-prev);
            }
            prev=curr;
        }
        curr++;
        n=n>>1;
      }
      return max;
    }
}
//OPTIMAL APPROACH-2
class Solution {
    public int binaryGap(int n) {
      
      int prev=-1;
      int max=0;
      for(int i=0;i<32;i++){
        if(((n>>i) & 1) >0){
            if(prev>=0){
                max=Math.max(max,i-prev);
            }
            prev=i;
        }
      }
      return max;
    }
}
