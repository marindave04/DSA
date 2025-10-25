class Solution {
    public int totalMoney(int n) {
        int money=1;
        int count=0;
        int sum=0;
        int week =0;
        for(int i=1;i<=n;i++){
            sum=sum+money;
            count++;
            money++;
            
            if(count==7){
                week++;
                money=1;
                money=money+week;
                count=0;
            }
        }
        return sum;
    }
}