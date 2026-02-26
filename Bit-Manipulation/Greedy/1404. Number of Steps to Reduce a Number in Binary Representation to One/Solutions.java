
class Solution {
    public int numSteps(String s) {
     int n=s.length();
     int op=0;
     int carry=0;
     for(int i=n-1;i>0;i--){
        int x=s.charAt(i)-'0'+carry;
        if(x%2!=0){
            op+=2;
            carry=1;
        }else{
            op+=1;
        }
     }
     return op+carry;
    }
}
