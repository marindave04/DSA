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
    ListNode HEAD;
    public Solution(ListNode head) {
        HEAD=head;
        
    }
    
    public int getRandom() {
        int count=1;
        int result=0;
        ListNode temp=HEAD;

        while(temp!=null){
            if(Math.random()<1.0/count){
                result=temp.val;
            }
            count++;
            temp=temp.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */