/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| **BFS + Parent Mapping (Burning Tree problem using level order traversal)** | **O(n)**        | **O(n)**         |

*/
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        // code here
        //using bfs
        //first tracking parent node of each node
        HashMap<Node ,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        map.put(root,null);
        q.offer(root);
        Node temp=null;
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
                
                Node curr=q.poll();
                if(curr.data==target){
                    temp=curr;
                }
                if(curr.left!=null){
                    map.put(curr.left,curr);
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    map.put(curr.right,curr);
                    q.add(curr.right);
                }
            }
        }
        //now we will burn the entire tree levelwise
        int t=-1;
        Queue<Node> q1=new LinkedList<>();
        HashSet<Node> visited=new HashSet<>();
        q1.offer(temp);
        while(!q1.isEmpty()){
            int lsize=q1.size();
            for(int i=0;i<lsize;i++){
                Node curr=q1.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    q1.add(curr.left);
                }
                 if(curr.right!=null && !visited.contains(curr.right)){
                    q1.add(curr.right);
                }
                if(map.get(curr)!=null && !visited.contains(map.get(curr))){
                    q1.add(map.get(curr));
                }
              visited.add(curr);
            }
            t++;
        }
        return t;
    }
}
