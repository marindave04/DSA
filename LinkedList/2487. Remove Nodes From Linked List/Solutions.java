/*
| Approach                                            | Time Complexity | Space Complexity |
| --------------------------------------------------- | --------------- | ---------------- |
| **Reverse + Greedy Deletion (Monotonic Traversal)** | **O(n)**        | **O(1)**         |

*/
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
    public ListNode removeNodes(ListNode head) {
        ListNode temp=reverse(head);
        ListNode i=temp;
        ListNode j=temp.next;
        while(j!=null){
            if(j.val<i.val){
                ListNode temp2=j.next;
                i.next=j.next;
                j=temp2;
            }else{
                i=j;
                j=j.next;
            }
        }
        ListNode ans=reverse(temp);
        return ans;
    }
    static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode pres=head;
        ListNode node=head.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=node;
            if(node!=null) node=node.next;
        }
        return prev;
    }
}
