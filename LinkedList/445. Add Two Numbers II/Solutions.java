//using reversing list concept
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode t1= reverse(l1);
     ListNode t2= reverse(l2);
      ListNode dummy = add(t1,t2);
     
      
      return reverse(dummy); 
    }
    static ListNode reverse(ListNode head){
       if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode pres=head;
        ListNode node=head.next;
        while(pres!=null){
             pres.next=prev;
             prev=pres;
             pres=node;
             if(node!=null) node=node.next;
        }
        return prev;
    }
    static ListNode add(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        while(temp1!=null || temp2!=null || carry==1){
            int sum=carry;
            if(temp1!=null){
                sum+=temp1.val;
                temp1=temp1.next;
            }
             if(temp2!=null){
                sum+=temp2.val;
                temp2=temp2.next;
            }
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            carry=sum/10;
        }
        return dummy.next;
    }
}
//using stack and head insertion technique
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      Stack<Integer> st1=new Stack<>();
       Stack<Integer> st2=new Stack<>();
       ListNode temp1=l1;
       ListNode temp2=l2;
       while(temp1!=null || temp2!=null){
        if(temp1!=null){
            st1.push(temp1.val);
            temp1=temp1.next;
       }
       if(temp2!=null){
        st2.push(temp2.val);
        temp2=temp2.next;
       }
    }
    int carry=0;
    ListNode dummy=null;
   
    while(!st1.isEmpty() || !st2.isEmpty() || carry==1){
        int sum=carry;
        if(!st1.isEmpty()){
            int val1=st1.pop();
            sum+=val1;
        }
         if(!st2.isEmpty()){
            int val2=st2.pop();
            sum+=val2;
        }
        ListNode curr=new ListNode(sum%10);
        curr.next=dummy;
        dummy=curr;
        carry=sum/10;
    }
    return dummy;
}
}
