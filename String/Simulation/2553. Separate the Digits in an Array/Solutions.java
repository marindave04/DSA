/*| Approach                                                         | Time Complexity  | Space Complexity | Reason                                        |
| ---------------------------------------------------------------- | ---------------- | ---------------- | --------------------------------------------- |
| Using `String` concatenation and converting characters to digits | (\boxed{O(d^2)}) | (\boxed{O(d)})   | `s = s + str` creates a new string every time |
*/
class Solution {
    public int[] separateDigits(int[] nums) {
        String s="";
        for(int i=0;i<nums.length;i++){
            String str=String.valueOf(nums[i]);
            s=s+str;
        }
        int n=s.length();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int val=ch-'0';
            ans[i]=val;
        }
        return ans;
    }
}
