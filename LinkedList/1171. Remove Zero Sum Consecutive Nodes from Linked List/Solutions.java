//Approach 1: Prefix Sum for Each Consecutive Sequence
//Time complexity: O(n^2)
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(-1,head);
        ListNode i=dummy;
        while(i!=null){
            int psum=0;
            ListNode j=i.next;
            while(j!=null){
                psum+=j.val;
                if(psum==0){
                    i.next=j.next;
                }
                j=j.next;
            }
            i=i.next;
        }
        return dummy.next;
    }
}
//Approach 2: Prefix Sum Hash Table
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        HashMap<Integer,ListNode> map=new HashMap<>();
        map.put(0,dummy);
        int psum=0;
        ListNode current=dummy;
        while(current!=null){
            psum+=current.val;
            map.put(psum,current);
            current=current.next;
        }
        psum=0;
        current=dummy;
        while(current!=null){
            psum+=current.val;
            current.next=map.get(psum).next;
            current=current.next;
        }
        return dummy.next;
    }
}
