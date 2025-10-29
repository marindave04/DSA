class Solution {
    public int smallestNumber(int n) {
        int pos=0;
        while(n>0){
            n=n>>1;
            pos++;
        }
        return (int)Math.pow(2,pos)-1;
    }
}