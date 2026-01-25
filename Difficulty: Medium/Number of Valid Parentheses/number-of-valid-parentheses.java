class Solution {
    static int count;
    int findWays(int n) {
        // code here
        count=0;
        solve("(",1,0,n);
        return count;
    }
    static void solve(String s,int count1,int count2,int n){
        if(s.length()>=n){
            if(count1==count2) count++;
            return;
        }
         
        if(count1>=count2){
             solve(s+'(',count1+1,count2,n);
             solve(s+')',count1,count2+1,n);
        }
    }
}
