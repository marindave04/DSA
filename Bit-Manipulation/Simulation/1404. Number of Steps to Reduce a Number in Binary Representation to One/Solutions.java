//Approach 1: Brute Force it gives TLE
  class Solution {
    public int numSteps(String s) {
        long num=0;
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            int bit=ch-'0';
            num=(long)num+bit*(long)Math.pow(2,n-1-i);
        }
        int steps=0;
        while(num!=1){
            if(num%2!=0) num=num+1;
            else num=num/2;
            steps++;
        }
        return steps;
    }
}
//Approach 2: Brute Force+BigInt
import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
       BigInteger num=new BigInteger(s,2);
       int steps = 0;

        while (!num.equals(BigInteger.ONE)) {

            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.TWO);
            } else {
                num = num.add(BigInteger.ONE);
            }

            steps++;
        }

        return steps;
    }
}
//Approach 3: Simulation

class Solution {
    public int numSteps(String s) {
       StringBuilder sb=new StringBuilder(s);
       int op=0;
       while(sb.length()>1){
        int n=sb.length();
        if(sb.charAt(n-1)=='1'){
            DivideByTwo(sb);
            op++;
        }else{
            addOne(sb);
            op++;
        }
       }
       return op;
    }
    private void DivideByTwo( StringBuilder sb){
       int i=sb.length()-1;
        while(i>=0 && sb.charAt(i)!='0'){
            sb.setCharAt(i,'0');
            i--;
        }
        if(i<0){
            sb.insert(0,'1');
        }else{
            sb.setCharAt(i,'1');
        }
    }
    private void addOne( StringBuilder sb){
       int i=sb.length();
        sb.deleteCharAt(i-1);
    }
}
