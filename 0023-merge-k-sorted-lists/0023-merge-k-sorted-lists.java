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
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(0,lists.length-1,lists);
    }
    static ListNode partition(int s,int e,ListNode[] lists){
        if(s>e) return null;
        if(s==e) return lists[s];
       int mid=s+(e-s)/2;
        ListNode L1=partition(s,mid,lists);
        ListNode L2=partition(mid+1,e,lists);
        return merge(L1,L2);
    }
    static ListNode merge(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){
            list1.next=merge(list1.next,list2);
            return list1;
        }
            list2.next=merge(list1,list2.next);
            return list2;
    }
}