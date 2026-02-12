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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode temp=head;
        ListNode prev=null;
        int size=0;
        while(temp!=null){
            size++;
            prev=temp;
            temp=temp.next;
        }
        k=k%size;
        if(k==0) return head;
        ListNode node=head;
        int pos=size-k;
        int count=1;
        while(count!=pos){
            count++;
            node=node.next;
        }
        ListNode newHead=node.next;
        node.next=null;
        prev.next=head;
        return newHead;
    }
}
