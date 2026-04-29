/*
| Approach                                                                                                                     | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse from right to left using monotonic increasing stack, pop all greater/equal elements, top gives next smaller element | **O(n)**        | **O(n)**         |

*/
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n=arr.length;
        int[] nums=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
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
