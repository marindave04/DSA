/*
| Approach                                                                                                                                | Time                 | Space        |
| --------------------------------------------------------------------------------------------------------------------------------------- | -------------------- | ------------ |
| Store all prefixes of numbers from first array in a hash set, then check prefixes of second array to find maximum common prefix length. | **O(N · D + M · D)** | **O(N · D)** |

*/

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
       HashSet<Integer> set1=new HashSet<>();
       for(int num:arr1){
        while(!set1.contains(num) && num>0){
              set1.add(num);
              num=num/10;
        }
       }
       int max=0;
       for(int num:arr2){
        while(num>0){
              if(set1.contains(num)){
                int l=solve(num);
                max=Math.max(max,l);
              }
              num=num/10;
        }
       }
       return max;
    }
    static int solve(int n1){
        int len=0;
          while(n1>0){
            len++;
            n1=n1/10;
          }
          return len;
    }
}
