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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        
      ListNode node1=head;
      ListNode node2=head.next;
      if(node2==null) return head;
      while(node2.next!=null){
        if(node1.val==node2.val){
            node1.next=node2.next;
            node2=node2.next;
        }else{
            node1=node2;
            node2=node2.next;
        }
      }
      if(node1.val==node2.val){
        node1.next=node2.next;
      }
      return head;
    }
}