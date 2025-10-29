class Solution {
    public int smallestNumber(int n) {
       int result=n;
       while(!checkAllBitSet(result)){
        result++;
       }
       return result;
    }
    static boolean checkAllBitSet(int result){
        if((result & (result+1))==0) return true;
        return false;
    }
}