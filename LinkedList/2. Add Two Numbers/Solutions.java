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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode i=l1;
        ListNode j=l2;
        int carry=0;
        while(i!=null || j!=null || carry==1){
          int sum=carry;
          if(i!=null){
            sum=sum+i.val;
            i=i.next;
          }
          if(j!=null){
            sum=sum+j.val;
            j=j.next;
          }
          curr.next=new ListNode(sum%10);
          curr=curr.next;
          carry=sum/10;
         
        }

        return dummy.next;
    }
}
