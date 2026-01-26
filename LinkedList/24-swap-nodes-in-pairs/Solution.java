// ## 24. Swap Nodes in Pairs

// **Approach:** Recursion

// **Algorithm:**
// - Swap first two nodes
// - Recursively swap remaining list
// - Return new head (second node)

// **Time Complexity:** O(n)  
// **Space Complexity:** O(n) (recursion stack)

// **Platform:** LeetCode
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
       ListNode first=head;
       ListNode second=head.next;
     // ab hum baaki list ko swap hone ke liye bhej denge
     ListNode rest=swapPairs(second.next);
     second.next=first;
     first.next=rest;
     return second;//this is the new head
    }
}

