class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
       int[] cumCountOne=new int[n];
       cumCountOne[0]=(s.charAt(0)=='1') ? 1 : 0;
       for(int i=1;i<n;i++){
        cumCountOne[i]=cumCountOne[i-1] +( (s.charAt(i)=='1') ? 1 : 0);
       }
       int result=0;
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int count1= cumCountOne[j] -(i>0 ? cumCountOne[i-1] : 0);
            int count0=(j-i+1)-count1;
            int z=count0*count0;
            if(z>count1){
                int need1=z-count1;
                j=j+need1-1;
            }else if(z==count1){
                result++;
            }else{
                result++;

                    int k = (int) Math.sqrt(count1) - count0;
                    int next = j + k;

                    if (next >= n) {
                        result += (n - j - 1);
                        break;
                    } else {
                        result += k;
                    }

                    j = next;
            }
        }
       }
       return result;
    }
}