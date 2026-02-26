//Approach 1: Monotonic Stack and Two Pass
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
      ArrayList<Integer> list=new ArrayList<>();
      ListNode node=head;
      while(node!=null){
        list.add(node.val);
        node=node.next;
      }
      Stack<Integer> st=new Stack<>();
      int[] ans=new int[list.size()];
      for(int i=0;i<list.size();i++){
        while(!st.isEmpty() && list.get(i)>list.get(st.peek())){
            ans[st.peek()]=list.get(i);
            st.pop();
        }
        st.push(i);
      }
      return ans;
    }
}
