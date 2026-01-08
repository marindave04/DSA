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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        if(n==1){
            return head.next;
        }
        int x=(int)Math.floor(n/2);
       
        ListNode node=head;
        for(int i=0;i<x-1;i++){
            node=node.next;
        }
        node.next=node.next.next;
        return head;
    }
}