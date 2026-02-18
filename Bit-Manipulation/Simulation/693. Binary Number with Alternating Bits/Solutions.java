class Solution {
    public boolean hasAlternatingBits(int n) {
        int idx=0;
        int prev=-1;
        while(n>0){
            int rem=n%2;
            if(prev==rem) return false;
            prev=rem;
            n=n/2;
        }
        return true;
    }
}
