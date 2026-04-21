//Brute Force
//TC-O(N);
//SC-O(N);
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
    public boolean isPalindrome(ListNode head) {
      //brute force approach ye rhega hmara ki hum original list ki copy bnaayenge and then usko revserse krke original list se compare krenge
     ListNode newHead=new ListNode(head.val);
     ListNode newCurr=newHead;
     ListNode oldCurr=head.next;
     while(oldCurr!=null){
        newCurr.next=new ListNode(oldCurr.val);
        oldCurr=oldCurr.next;
        newCurr=newCurr.next;
     }
     ListNode head2=reverseList(newHead);
        ListNode p1 = head;
        ListNode p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    
    }
     static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return dummy;
    }
}
//OPTIMAL APPROACH
//TC-O(N);
//SC-O(1);
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
    public boolean isPalindrome(ListNode head) {
      //optimal approach-> mid find krenge ,uske baaad right half ko reverse krenge phir left half aur right half ko compare krenge and last me list ko restore krenge by re-reversing the right half
      ListNode mid=middleNode(head);
      ListNode newHead= reverseList(mid);
      ListNode restoreHead=newHead;
      while(head!=null && newHead!=null){
        if(head.val!=newHead.val) break;
        head=head.next;
        newHead=newHead.next;
      }
       reverseList(restoreHead);// ye bs hum apni list ko restore krne ke liye krte hai
       if(head==null || newHead==null) return true;
       return false;
    }
     static ListNode middleNode(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;
       while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;

       } 
       return slow;
    }
     static ListNode reverseList(ListNode head) {
        // iterative approach
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode pres=head;
        ListNode node=head.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=node;
            if(node!=null) node=node.next;
        }
        return prev;
    }
}
/*
| Approach                                                                   | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------- | --------------- | ---------------- |
| **Find middle (slow-fast), reverse second half, then compare both halves** | **O(n)**        | **O(1)**         |

*/
class Solution {
    public boolean isPalindrome(ListNode head) {
      if(head==null || head.next==null) return true;
       ListNode slow=head;
       ListNode fast=head;
       ListNode p=null;
       while(fast!=null && fast.next!=null){
         p=slow;
         slow=slow.next;
         fast=fast.next.next;
       }
       ListNode temp=slow;
       if(slow.next!=null){
        temp=temp.next;
       }
       p.next=null;
        ListNode prev=null;
        ListNode pres=temp;
        ListNode node=temp.next;
        while(pres!=null){
           pres.next=prev;
           prev=pres;
           pres=node;
           if(node!=null) node=node.next;
        }
        ListNode l1=head;
        ListNode l2=prev;
        while(l1!=null && l2!=null){
            if(l1.val!=l2.val) return false;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            if(l1.val!=slow.val) return false;
        }
        return true;
    }
}
