// Iterative Approach

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
      // phle dono list me traversal ke liye do nodes create krte hai
      ListNode node1=list1;
      ListNode node2=list2;
      //ab ek dummy node bnaate hai jo answer nodes ko add krne me kaam aayega   
      ListNode dummy=new ListNode(-1);
      //abb ek aur traversal node jo answwer me traverse krega
      ListNode curr=dummy;
      while(node1!=null && node2!=null){
        if(node1.val<=node2.val){
            curr.next=new ListNode(node1.val);
            curr=curr.next;
            node1=node1.next;
        }else if(node2.val<node1.val){
            curr.next=new ListNode(node2.val);
            curr=curr.next;
            node2=node2.next;
        }
      }
      while(node1!=null){
           curr.next=new ListNode(node1.val);
            curr=curr.next;
            node1=node1.next;
      }
      while(node2!=null){
            curr.next=new ListNode(node2.val);
            curr=curr.next;
            node2=node2.next;
      }
      return dummy.next;
    }
}
//Recursive Approach
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        
    }
}
