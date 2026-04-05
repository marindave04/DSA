/*
| Approach                        | Time Complexity | Space Complexity |
| ------------------------------- | --------------- | ---------------- |
| **Counting moves (L, R, U, D)** | **O(n)**        | **O(1)**         |

*/
class Solution {
    public boolean judgeCircle(String moves) {
        int l=0;
        int r=0;
        int u=0;
        int d=0;
        for(int i=0;i<moves.length();i++){
          if(moves.charAt(i)=='L'){
               l++;
          }else if(moves.charAt(i)=='R'){
                r++;
          }else if(moves.charAt(i)=='U'){
                 u++;
          }else if(moves.charAt(i)=='D'){
                 d++;
          }
        }
      if(l==r && u==d) return true;
      return false;
    }
}
