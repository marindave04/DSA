//Approach-1
/*| Type  | Complexity |
| ----- | ---------- |
| Time  | **O(2^n)** |
| Space | **O(n)**   |
*/
class Solution {
    public String findDifferentBinaryString(String[] nums) {
      HashSet<Integer> set=new HashSet<>();
      for(int i=0;i<nums.length;i++){
        int num=Integer.parseInt(nums[i],2);
        set.add(num);
      }
      int n=nums.length;
      int x=(int)Math.pow(2,n)-1;
      int ans=0;
      for(int i=0;i<=x;i++){
        if(!set.contains(i)){
          ans=i;
          break;
        }
      }
     String binary = Integer.toBinaryString(ans);
     StringBuilder sb = new StringBuilder();
     for(int i=binary.length();i<n;i++){
        sb.append('0');
     }
     sb.append(binary);
     return sb.toString();
    }
}
//Approach-2
/*
| Type  | Complexity |
| ----- | ---------- |
| Time  | **O(n²)**  |
| Space | **O(n)**   |

*/
class Solution {
    public String findDifferentBinaryString(String[] nums) {
      HashSet<Integer> set=new HashSet<>();
      for(int i=0;i<nums.length;i++){
        int num=Integer.parseInt(nums[i],2);
        set.add(num);
      }
      int n=nums.length;
      
      int ans=0;
      for(int i=0;i<=n;i++){
        if(!set.contains(i)){
          ans=i;
          break;
        }
      }
     String binary = Integer.toBinaryString(ans);
     StringBuilder sb = new StringBuilder();
     for(int i=binary.length();i<n;i++){
        sb.append('0');
     }
     sb.append(binary);
     return sb.toString();
    }
}
