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
    public ListNode swapPairs(ListNode head) {
        ListNode prev = head;
        ListNode curr=head;
        if(curr==null) return head;
        int count=1;
        while(curr!=null){
           if(count%2==0){
            int temp=curr.val;
            curr.val=prev.val;
            prev.val=temp;
            prev=curr.next;
           }
           count++;
           curr=curr.next;
           
        }
        return head;
    }
}