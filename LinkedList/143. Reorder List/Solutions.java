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
    public void reorderList(ListNode head) {
     
     ListNode p1=head;
     ListNode p2=middleNode(head);
     p2=reverseList(p2);
     while(p1!=null && p2!=null){
        ListNode t1 = p1.next;
        ListNode t2 = p2.next;
        p1.next=p2;
        p2.next=t1;
        p1=t1;
        p2=t2;
     }

    }
    static ListNode middleNode(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;
      
       while(fast!=null && fast.next!=null){
         
          slow=slow.next;
          fast=fast.next.next;

       } 
       ListNode second=slow.next;
       slow.next=null;
       return second;
    }
    static ListNode reverseList(ListNode head) {
        // iterative approach
        if(head==null || head.next==null) return head;
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
