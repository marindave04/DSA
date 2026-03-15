/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| **BFS (Level Order Traversal) + Horizontal Distance Mapping using TreeMap** | **O(n log n)**  | **O(n)**         |

*/
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
       Map<Integer,Integer> map=new TreeMap<>();
       Queue<Object[]> q=new LinkedList<>();
       q.offer(new Object[]{root,0});
       while(!q.isEmpty()){
           Object[] curr=q.poll();
           Node node=(Node)curr[0];
           int hd=(int)curr[1];
           if(!map.containsKey(hd)){
               map.put(hd,node.data);
           }
           if(node.left!=null){
               q.offer(new Object[]{node.left,hd-1});
           }
           if(node.right!=null){
               q.offer(new Object[]{node.right,hd+1});
           }
       }
       ArrayList<Integer> result=new ArrayList<>();
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           result.add(entry.getValue());
       }
       return result;
    }
}
