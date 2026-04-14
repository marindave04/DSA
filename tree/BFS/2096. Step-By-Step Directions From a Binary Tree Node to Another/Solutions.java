/*
| Approach                                                  | Time Complexity | Space Complexity |
| --------------------------------------------------------- | --------------- | ---------------- |
| **BFS on Tree (with Parent Mapping + Path Backtracking)** | **O(n)**        | **O(n)**         |

*/
//Since this question involves calculating shortest path betwwen source and destination so we can think of bfs
class Solution {
    public String getDirections(TreeNode root, int s, int e) {
       //we will run bfs from starting node
       TreeNode start=findStartNode(root,s);
       //we will make and populate the parentmap to move upwad in a tree;
       HashMap<TreeNode,TreeNode> parentNode=new HashMap<>();
       populateParentNode(parentNode,root);
       HashMap<TreeNode,Pair<TreeNode,String>> path=new HashMap<>();
       Queue<TreeNode> q=new LinkedList<>();
       q.offer(start);
       HashSet<TreeNode> visited=new HashSet<>();
       visited.add(start);
       while(!q.isEmpty()){
        TreeNode curr=q.poll();
        if(curr.val==e){
            return backTrackPath(path,curr);
        }
        if(parentNode.containsKey(curr)){
            TreeNode parent=parentNode.get(curr);
            if(!visited.contains(parent)){
                q.offer(parent);
                visited.add(parent);
                path.put(parent,new Pair<>(curr,"U"));
            }
        }
        //check left
        if(curr.left!=null && !visited.contains(curr.left)){
                q.offer(curr.left);
                visited.add(curr.left);
                path.put(curr.left,new Pair<>(curr,"L"));
        }
        //check right
        if(curr.right!=null && !visited.contains(curr.right)){
                q.offer(curr.right);
                visited.add(curr.right);
                path.put(curr.right,new Pair<>(curr,"R"));
        }
       }
       return "";
    }
    static TreeNode findStartNode(TreeNode root,int s){
        if(root==null) return null;
        if(root.val==s) return root;
        TreeNode left=findStartNode(root.left,s);
        if(left!=null) return left;
        return findStartNode(root.right,s);
    }
    static void populateParentNode(HashMap<TreeNode,TreeNode> parentNode,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parentNode.put(root.left,root);
        }
        populateParentNode(parentNode,root.left);
        if(root.right!=null){
            parentNode.put(root.right,root);
        }
        populateParentNode(parentNode,root.right);
    }
    static String backTrackPath(HashMap<TreeNode,Pair<TreeNode,String>> path,TreeNode node){
        StringBuilder sb=new StringBuilder();
        while(path.containsKey(node)){
            sb.append(path.get(node).getValue());
            node=path.get(node).getKey();
        }
        sb.reverse();
        return sb.toString();
    }
}
