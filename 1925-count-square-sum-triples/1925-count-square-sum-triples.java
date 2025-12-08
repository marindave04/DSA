class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int a=i;
            for(int j=i+1;j<=n;j++){
                int b=j;
                int c=a*a+b*b;
                int temp=(int)Math.sqrt(c);
                if((temp*temp)==c && temp<=n){
                    count+=2;
                }
            }
        }
        return count;
    }
}