// BRUTE FORCE
class Solution {
    public int getCount(int n, int d) {
        // code here
        int count=0;
        for(int i=1;i<=n;i++){
            if(i-sumDigits(i)>=d){
                count++;
            }
        }
        return count;
    }
    static int sumDigits(int num){
        int sum=0;
        while(num>0){
            sum=sum+num%10;
            num=num/10;
        }
        return sum;
    }
};
//OPTIMAL SOLUTION
class Solution {
    public int getCount(int n, int d) {
        // code here
        int low=1;
        int high=n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(check(mid,d)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return n-high;
    }
    static boolean check(int mid,int d){
        if(mid-sumDigits(mid)>=d) return true;
        return false;
    }
    static int sumDigits(int num){
        int sum=0;
        while(num>0){
            sum=sum+num%10;
            num=num/10;
        }
        return sum;
    }
};
