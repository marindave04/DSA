/*
| Approach                                                            | Time Complexity          | Space Complexity |
| ------------------------------------------------------------------- | ------------------------ | ---------------- |
| **Linked List Traversal + Insert GCD nodes between adjacent nodes** | **O(n · log(max(a,b)))** | **O(1)**         |

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2!=null){
            int a=p1.val;
            int b=p2.val;
            int c=gcd(a,b);
            ListNode node=new ListNode(c);
            p1.next=node;
            node.next=p2;
            p1=p2;
            p2=p2.next;
        }
        return head;
    }
    static int gcd(int a ,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
