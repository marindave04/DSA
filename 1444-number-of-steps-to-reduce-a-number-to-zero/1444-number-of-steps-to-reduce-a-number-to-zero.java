class Solution {
    public int numberOfSteps(int num) {
        return steps(num,0);
    }
    static int steps(int n,int count){
        if(n==0){
            return count;
        }
        if(n%2==0) return steps(n/2,count+1);
        return steps(n-1,count+1);
    }
}