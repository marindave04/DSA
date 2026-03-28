/*
| Approach                                                                | Time Complexity | Space Complexity                   |
| ----------------------------------------------------------------------- | --------------- | ---------------------------------- |
| **Single Pass Linked List Traversal (Accumulate values between zeros)** | **O(n)**        | **O(1)** *(excluding output list)* |

*/
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
    public ListNode mergeNodes(ListNode head) {
         ListNode dummy=new ListNode(-1);
         ListNode curr=dummy;
         ListNode temp=head;
         ListNode node=head.next;
         int value=0;
         while(node!=null){
             while(node.val!=0){
                value=value+node.val;
                node=node.next;
             }
             curr.next=new ListNode(value);
             curr=curr.next;
             temp=node;
             node=node.next;
             value=0;
         }
         return dummy.next;
    }
}
/*
| Approach                                                           | Time Complexity | Space Complexity             |
| ------------------------------------------------------------------ | --------------- | ---------------------------- |
| **Recursive Traversal (Sum nodes between zeros and rebuild list)** | **O(n)**        | **O(n)** *(recursion stack)* |

*/

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
    public ListNode mergeNodes(ListNode head) {
        head=head.next;
        if(head==null){
            return head;
        }
        int sum=0;
        ListNode temp=head;
        while(temp.val!=0){
            sum+=temp.val;
            temp=temp.next;
        }
        head.val=sum;
        head.next=mergeNodes(temp);
        return head;
    }
}
