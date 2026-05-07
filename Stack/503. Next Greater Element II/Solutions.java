/*| Approach                                                                                                                                                      | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Simulate circular array by duplicating array to size `2n`, then use monotonic decreasing stack from right to left to find next greater element for each index | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] temp=new int[2*n];
        for(int i=0;i<2*n;i++){
            temp[i]=nums[i%n];
        }
        int[] ans=new int[2*n];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=temp[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(temp[i]);
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=ans[i];
        }
        return res;
    }
}
