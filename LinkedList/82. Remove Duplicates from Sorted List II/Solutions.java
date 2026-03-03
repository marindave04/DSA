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
    if(head==null || head.next==null) return head;
       ListNode p=null;
       ListNode s=head;
       ListNode f=head.next;
       while(f!=null){
        if(s.val!=f.val){
            p=s;
            s=f;
            f=f.next;
        }else{
             while(f!=null && s.val==f.val){
            f=f.next;
        }
        if(p!=null){
            p.next=f;
            s=f;
           if(f!=null) f=f.next;
        }else if(p==null){
            head=f;
            s=f;
            p=null;
           if(f!=null) f=f.next;
        }
        }
       
       }
       return head;
    }
}
