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
    public ListNode reverseKGroup(ListNode head, int k) {
        // mera idea ye hai ki hr recursive call me main k groups of nodes ko recursive call me bhjeunga
        // uske liye phle mereko ye check krna prega ki k nodes available hai ki nhi 
        ListNode temp=head;
        int size=0;
        while(size<k && temp!=null){
            size++;
            temp=temp.next;
        }
        if(size<k) return head;
        //else hum recursive call krenge
        ListNode rest=reverseKGroup(temp,k);
        //ab hum in k nodes ko reverse krenge
        ListNode curr=head;
        ListNode prev=rest;
        for(int i=0;i<k;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
