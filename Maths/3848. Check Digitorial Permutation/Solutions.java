class Solution {
    public boolean isDigitorialPermutation(int n) {
       long lembda=0;
        long y=n;
        while(n>0){
            int x=n%10;
            lembda=lembda+fact(x);
            n=n/10;
        }
        int[] freq=new int[10];
        while(y>0){
            freq[(int)y%10]++;
            y=y/10;
        }
         while(lembda>0){
            freq[(int)lembda%10]--;
            lembda=lembda/10;
        }
        for(int i=0;i<10;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
    static long fact(int n){
        if(n < 2) return 1;
        long fact=1;
        for(int i=2;i<=n;i++){
            fact= (long)fact*i;
        }
        return fact;
    }
   
}
