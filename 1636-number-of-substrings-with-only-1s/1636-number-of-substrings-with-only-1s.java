class Solution {
    public int numSub(String s) {
        int i=0;
        int j=0;
        long count=0;
        long mod = 1000000007;

        while(j<s.length()){
            if(s.charAt(i)=='0' && s.charAt(j)=='0'){
                i++;
                j++;
            }else if(s.charAt(i)=='1' && s.charAt(j)=='1'){
                j++;
            }else if(s.charAt(i)=='1' && s.charAt(j)=='0'){
                long n=j-i;
                count = (count + n*(n+1)/2) % mod;
                i=j;
            }
        }

        long rem = s.length()-i;
        count = (count + rem*(rem+1)/2) % mod;

        return (int)count;
    }
}
