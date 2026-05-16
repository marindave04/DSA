/*
| Approach                                                                                                                                       | Time     | Space    |
| ---------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use prefix count of `L` and suffix count of `T` to compute all possible `LCT` subsequences, while checking best insertion of `L`, `C`, or `T`. | **O(N)** | **O(N)** |

*/
class Solution {
    public long numOfSubsequences(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        long[] prefix=new long[n];
        int count1=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='L') count1++;
            prefix[i]=count1;
        }
        long[] suffix=new long[n+1];
        int count2=0;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='T') count2++;
            suffix[i]=count2;
        }
        long ansWithC=0;
        long ansWithL=0;
        long ansWithT=0;
        long bestPosForC=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='C'){
                ansWithC+=prefix[i]*suffix[i+1];
                ansWithL+=(prefix[i]+1)*suffix[i+1];
                ansWithT+=prefix[i]*(suffix[i+1]+1);
            }else {
                bestPosForC=Math.max(bestPosForC,prefix[i]*suffix[i]);
            }
        }
        ansWithC+=bestPosForC;
        return Math.max(ansWithC,Math.max(ansWithL,ansWithT));
    }
}
