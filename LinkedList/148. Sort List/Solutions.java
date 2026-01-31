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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid=middleNode(head);
        ListNode list1=sortList(head);
        ListNode list2=sortList(mid);
        return mergeTwoLists(list1,list2);
    }
     static ListNode middleNode(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;
       ListNode prev=null;
       while(fast!=null && fast.next!=null){
          prev=slow;
          slow=slow.next;
          fast=fast.next.next;

       } 
       prev.next=null;
       return slow;
    }
      static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        
    }
}
