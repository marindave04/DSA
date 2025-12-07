class Solution {
    public int countOdds(int low, int high) {
       long midcount = (long)(high-low-1);
       if(midcount==-1){
        if(low%2!=0) return 1;
        else return 0;
       }
       long odd=(long)midcount/2;
       if(low%2!=0) odd++;
       if(high%2!=0) odd++;
       if(low%2==0 && high%2==0) return (int)odd+1;
       return (int)odd;
    }
}