class Solution {
    public int countPrimeSetBits(int left, int right) {
         int ans=0;
        for(int i=left;i<=right;i++){
            int count=0;
            int n=i;
            while(n>0){
                int rem=n%2;
                if(rem==1) count++;
                n=n/2;
            }
            if(prime(count)) ans++;
        }
        return ans;
    }
    static boolean prime(int x){
         return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}
