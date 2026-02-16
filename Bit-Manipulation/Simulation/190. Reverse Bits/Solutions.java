class Solution {
    public int reverseBits(int n) {
        int[] bits=new int[32];
        int idx=31;
        while(n>0){
            bits[idx--]=n%2;
            n=n/2;
        }
        reverse(bits);
        int ans=0;
        for(int i=31;i>=0;i--){
            ans=(int)ans+(int)bits[i]*(int)Math.pow(2,31-i);
        }
        return ans;
    }
    static void reverse(int[] bits){
        int i=0;
        int j=31;
        while(i<j){
            int temp=bits[i];
            bits[i]=bits[j];
            bits[j]=temp;
            i++;
            j--;
        }
    }
}
