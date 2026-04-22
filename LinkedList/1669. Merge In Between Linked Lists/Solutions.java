/*
| Approach                                                                                 | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse list1 using counter to find (a-1) and (b+1), attach list2 in between using tail | **O(n + m)**    | **O(1)**         |

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode e=list2;
        ListNode s=list2;
        while(e.next!=null){
            e=e.next;
        }
        ListNode temp1=list1;
        ListNode temp2=list1;
        int count=0;
        while(temp1!=null){
           if(count==a-1){
            temp2=temp1.next;
            temp1.next=s;
            count++;
            break;
           }
           temp1=temp1.next;
           count++;
        }
        while(temp2!=null){
           if(count==b+1){
            e.next=temp2;
            break;
           }
           temp2=temp2.next;
           count++;
        }
        return list1;
    }
}
/*
| Approach                                                                                        | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Find tail of list2, move pointer1 to (a-1) and pointer2 to (b+1), then connect list2 in between | **O(n + m)**    | **O(1)**         |

*/
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode e=list2;
        ListNode s=list2;
        while(e.next!=null){
            e=e.next;
        }
        ListNode pointer1=list1;
        for(int i=0;i<a-1;i++){
            pointer1=pointer1.next;
        }
         ListNode pointer2=list1;
        for(int i=0;i<b+1;i++){
            pointer2=pointer2.next;
        }
        pointer1.next=s;
        e.next=pointer2;
        return list1;
    }
}
