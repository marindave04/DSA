/*
| Approach                                                                                                            | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Use sliding window with frequency count of `0,1,2`, expand right and shrink left while all three digits are present | **O(n)**        | **O(1)**         |

*/
class Solution {
    public int smallestSubstring(String s) {
        // code here
        int n=s.length();
        int[] f=new int[3];
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        while(j<n){
            char ch=s.charAt(j);
            f[ch-'0']++;
            while(f[0]!=0 && f[1]!=0 && f[2]!=0){
                min=Math.min(min,j-i+1);
                f[s.charAt(i)-'0']--;
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
};
