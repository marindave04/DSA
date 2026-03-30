/*
| Approach                                                                | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------- | --------------- | ---------------- |
| **Reverse Linked List + Digit-wise Doubling with Carry + Reverse back** | **O(n)**        | **O(1)**         |

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
    public ListNode doubleIt(ListNode head) {
        ListNode temp1=reverse(head);
        ListNode temp=temp1;
        ListNode prev=null;
        int carry=0;
        while(temp!=null){
            int value=2*temp.val+carry;
            temp.val=value%10;
            carry=value/10;
            prev=temp;
            temp=temp.next;
        }
        if(carry>0){
            prev.next=new ListNode(carry);
        }
        return reverse(temp1);
    }
    static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode node=head.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=node;
            if(node!=null) node=node.next;
        }
        return prev;
    }
}
