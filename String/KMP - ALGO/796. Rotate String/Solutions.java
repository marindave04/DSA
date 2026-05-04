/*
| Approach                                                                                                                                             | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Concatenate string with itself (`s+s`), then for every starting index manually compare substring characters with `goal` to check full rotation match | **O(n²)**       | **O(n)**         |

*/
class Solution {
    public boolean rotateString(String s, String goal) {
      String str=s+s;
      if(s.length()!=goal.length()) return false;
      for(int i=0;i<str.length();i++){
        int j=i;
        int k=0;
        while(j<str.length()&&k<goal.length()){
            if(str.charAt(j)!=goal.charAt(k)){
                break;
            }else{
                j++;
                k++;
            }
        }
        if(k>=goal.length()) return true;
      
      }
      return false;
    }
}

/*
| Approach                                                                                                                                        | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Concatenate `s+s`, build LPS array of `goal`, then apply KMP pattern matching to efficiently search whether `goal` exists inside doubled string | **O(n)**        | **O(n)**         |

*/
class Solution {
    public boolean rotateString(String s, String goal) {
    if(s.length()!=goal.length()) return false;
       String str=s+s;
       int n=goal.length();
       int[] lps=solve(goal);
       int i=0;
       int j=0;
       int m=str.length();
       while(i<m){
        if(str.charAt(i)==goal.charAt(j)){
            i++;
            j++;
            if(j>=n) return true;
        }else if(j>0){
            j=lps[j-1];
        }else{
            i++;
        }
       }
       return false;
    }
    static int[] solve(String pattern){
         int[] lps=new int[pattern.length()];
        lps[0]=0;
        int i=1;
        int len=0;
       
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                     len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}
