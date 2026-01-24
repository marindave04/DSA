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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode curr=head;
        ListNode prev=null;
        //finding last so that we can connect it to prev 
        for(int i=0;curr!=null && i<left-1;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode last=prev;
        // storing newEnd so that we can connect it to curr;
        ListNode newNode=curr;
        //now reverse given block
        ListNode node=curr.next;
        for(int i=0; curr!=null && i<right-left+1;i++){
            curr.next=prev;
            prev=curr;
            curr=node;
            if(node!=null){
                node=node.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }
        newNode.next=curr;
        return head;
    }
}