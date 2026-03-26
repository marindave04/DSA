/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| **Single Pass + Store Critical Indices (ArrayList) then compute distances** | **O(n)**        | **O(n)**         |

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       ArrayList<Integer> list=new ArrayList<>();
       ListNode p=head;
       ListNode curr=head.next;
       int count=2;
       while(curr.next!=null){
          if(curr.val>p.val && curr.val>curr.next.val){
            list.add(count);
          }else  if(curr.val<p.val && curr.val<curr.next.val){
            list.add(count);
          }
          p=curr;
          curr=curr.next;
          count++;
       } 
       if(list.size()<2) return new int[]{-1,-1};
       int[] ans=new int[2];
       
       ans[1]=(list.get(list.size()-1)-list.get(0));
       int min=Integer.MAX_VALUE;
       for(int i=0;i<list.size()-1;i++){
        min=Math.min(min,(int)Math.abs(list.get(i)-list.get(i+1)));
        
       }
       ans[0]=min;
       return ans;
    }
}
/*
| Approach                                                                     | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------- | --------------- | ---------------- |
| **Single Pass Traversal (Track critical points & distances in linked list)** | **O(n)**        | **O(1)**         |

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
      
       ListNode p=head;
       ListNode curr=head.next;
       int count=2;
       int first=-1;
       int last=-1;
       int min=Integer.MAX_VALUE;
       while(curr.next!=null){
          if((curr.val>p.val && curr.val>curr.next.val) ||(curr.val<p.val && curr.val<curr.next.val)){
             if(first==-1){
                first=count;
             }else{
                min=Math.min(min,count-last);
             }
            last=count;
          }
          p=curr;
          curr=curr.next;
          count++;
       } 
      if(first==-1 || first==last) {
        return new int[]{-1,-1};
      }
      int max=last-first;
      return new int[]{min,max};
    }
}
