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
//Approach 2: Monotonic Stack, 1 Pass
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
       Stack<int[]> st=new Stack<>();
       int idx=0;
       while(head!=null){
        list.add(0);
        while(!st.isEmpty() && head.val>st.peek()[1]){
            int[] curr=st.peek();
            int id=curr[0];
            int val=curr[1];
            st.pop();
            list.set(id,head.val);
        }
        st.add(new int[]{idx++,head.val});
        head=head.next;
       }
       return list.stream().mapToInt(i->i).toArray();
    }
}
