/*
| Approach                                                                                                                              | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse from left to right using monotonic increasing stack, remove greater/equal elements, stack top gives previous smaller element | **O(n)**        | **O(n)**         |

*/
class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
         int n=arr.length;
        int[] nums=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nums[i]=-1;
            }else{
                nums[i]=st.peek();
            }
            st.push(arr[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : nums) {
            ans.add(x);
        }
        return ans;
    }
}
