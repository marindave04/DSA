class Solution {
    public int totalMoney(int n) {
       if(n<=7) return n*(n+1)/2;
       int a=28;
       int d=7;
       int week=n/7;
       int days=n%7;
       int l=a+(week-1)*d;
       double s1=(week/2.0)*(a+l);
       for(int i=week+1;i<=week+days;i++ ){
        s1=s1+i;
       }
       return (int)s1;
    }
}