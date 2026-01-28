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
    public ListNode swapNodes(ListNode head, int k) {
        if(head== null) return head;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size==1) return head;
        if(k>size/2){
            k=(size+1)-k;
        }
        ListNode node1=head;
        ListNode node2=head;
        ListNode p1=null;
        ListNode p2=null;
        int new_k=(size-k)+1;

        temp=head;
        size=0;
        while(temp!=null){
            size++;
            if(size==k-1) p1=temp;
            if(size==k) node1=temp;
            if(size==new_k-1) p2=temp;
            if(size==new_k) node2=temp;
            temp=temp.next;
        }
        if(k==1){
            p2.next=node1;
            ListNode flag=node1.next;
            node1.next=p1;
            node2.next=flag;
            head=node2;
        }else if(node1.next==node2){
            p1.next=node2;
            node1.next=node2.next;
            node2.next=node1;
        }else{
            p1.next=node2;
            ListNode flag=node1.next;
            node1.next=node2.next;
            node2.next=flag;
            p2.next=node1;
        }
        return head;
    }
}
