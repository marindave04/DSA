/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse circular list to find correct position and insert node accordingly | **O(n)**        | **O(1)**         |

*/
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        if(data<head.data){
             Node p1=null;
             Node p2=head;
              do{
             
                p1=p2;
                p2=p2.next;
            }while(p2!=head);
            Node root=new Node(data);
            root.next=p2;
            p1.next=root;
            return root;
        }
        
        Node p1=null;
        Node p2=head;
        do{
             if(p2.data>=data){
                Node temp=p1.next;
                Node node=new Node(data);
                p1.next=node;
                node.next=temp;
                break;
            }else{
                p1=p2;
                p2=p2.next;
            }
        }while(p2!=head);
        if(p2==head ){
             Node node=new Node(data);
             p1.next=node;
             node.next=p2;
        }
        return head;
    }
}
