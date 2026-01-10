/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                //cycle detected
                ListNode p=head;
                while(true){
                    if(p==slow) return slow;
                    p=p.next;
                    slow=slow.next;
                }
            }
        }
        return null;
    }
}