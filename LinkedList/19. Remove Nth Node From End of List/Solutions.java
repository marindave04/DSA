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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
    
        n=n%size;
        if(n==0) return head.next;
        int k=size-n;
        if(k==0) return head;
        int count=1;
        temp=head;
        while(count!=k){
            count++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}
//one pass solution
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       //phle fast pointer ko n steps aage kro;
       ListNode fast=head;
       for(int i=0;i<n;i++){
        fast=fast.next;
       }
       // ab slow aur fast pointer ko move kro ek saath;
       if(fast==null) return head.next;
       ListNode slow=head;
       while(fast.next!=null){
        fast=fast.next;
        slow=slow.next;
       }
       slow.next=slow.next.next;//deletion
       return head;
    }
}
