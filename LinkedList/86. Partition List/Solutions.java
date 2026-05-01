/*
| Approach                                                                                                                                                          | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse linked list, store values `< x` in first ArrayList and `>= x` in second, merge both lists, then create a completely new linked list in partitioned order | **O(n)**        | **O(n)**         |

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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> list1=new ArrayList<>();
         ArrayList<Integer> list2=new ArrayList<>();
         ListNode temp=head;
         while(temp!=null){
            if(temp.val<x){
                list1.add(temp.val);
            }else{
                list2.add(temp.val);
            }
            temp=temp.next;
         }
         list1.addAll(list2);
         ListNode dummy=new ListNode(-1);
         temp=dummy;
         for(int i=0;i<list1.size();i++){
            temp.next=new ListNode(list1.get(i));
            temp=temp.next;
         }
         return dummy.next;
    }
}
/*
| Approach                                                                                                                                                    | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse original list once, build two new linked lists: one for nodes `< x` and one for nodes `>= x`, then connect first list’s tail to second list’s head | **O(n)**        | **O(n)**         |

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
    public ListNode partition(ListNode head, int x) {
    ListNode list1=new ListNode(-1);
    ListNode list2=new ListNode(-1);
    ListNode ptr1=list1;
    ListNode ptr2=list2;
    ListNode ptr=head;
    while(ptr!=null){
        if(ptr.val<x){
            ptr1.next=new ListNode(ptr.val);
            ptr1=ptr1.next;
        }else{
            ptr2.next=new ListNode(ptr.val);
            ptr2=ptr2.next;
        }
        ptr=ptr.next;
    }
    ptr1.next=list2.next;
    return list1.next;
    }
}
