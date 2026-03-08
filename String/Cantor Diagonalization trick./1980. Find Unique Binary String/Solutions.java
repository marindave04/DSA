/*
| Type  | Complexity |
| ----- | ---------- |
| Time  | **O(n)**   |
| Space | **O(n)**   |

*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
     int n=nums.length;
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<n;i++){
        int flip=Math.abs(nums[i].charAt(i)-'0'-1);
        char ch=(char)(flip+'0');
        sb.append(ch);
      }
     return sb.toString();
    }
}
