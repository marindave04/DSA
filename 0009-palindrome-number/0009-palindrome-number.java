class Solution {
    public boolean isPalindrome(int x) {
        if(x==rev(x)) return true;
        return false;
    }
    static int rev(int x){
        int num=0;
        while(x>0){
            num=num*10+x%10;
            x=x/10;
        }
        return num;
    }
}