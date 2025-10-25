class Solution {
    public int totalMoney(int n) {
       if(n<=7) return n*(n+1)/2;
       int a1=28;
       int d1=7;
       int n1=n/7;
       int days=n%7;
       int l1=a1+(n1-1)*d1;
       double s1=(n1/2.0)*(a1+l1);
       int a2=n1+1;
       int d2=1;
       int n2=days;
       int l2=a2+(n2-1)*d2;
       double s2=(n2/2.0)*(a2+l2);
       return (int)(s1+s2);
    }
}