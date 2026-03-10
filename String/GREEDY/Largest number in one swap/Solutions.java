/*
| Approach                                                    | Time Complexity | Space Complexity         |
| ----------------------------------------------------------- | --------------- | ------------------------ |
| Greedy (largest possible digit ko right side se swap karna) | **O(n)**        | **O(n)** (StringBuilder) |

*/
class Solution {
    public String largestSwap(String s) {
      // we will store the last index of largest digit in a string
      StringBuilder sb=new StringBuilder(s);
      int idx=0;
      int i=9;
     while(i>=0 && idx<sb.length()){
         if(sb.charAt(idx)-'0'==i){
             idx++;
             continue;
         }else{
             int j=sb.length()-1;
             while(j>idx && sb.charAt(j)-'0'!=i){
                 j--;
             }
             if(j!=idx){
                char temp = sb.charAt(idx);
                sb.setCharAt(idx, sb.charAt(j));
                sb.setCharAt(j, temp);
                break;
             }else{
               v                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
             }
         }
     }
     return sb.toString();
    }
}
