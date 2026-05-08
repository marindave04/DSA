/*
| Approach                                                                                                                                                       | Time Complexity | Space Complexity               |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ------------------------------ |
| For every node of first tree, recursively check whether both trees are structurally identical with same node values; if not, search in left and right subtrees | **O(n × m)**    | **O(h₁ + h₂)** recursive stack |

*/
/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        if(root2==null) return true;
        if(root1==null) return false;
        if(solve(root1,root2)) return true;
        boolean left=isSubTree(root1.left,root2);
        boolean right=isSubTree(root1.right,root2);
        return left||right;
    }
    static boolean solve(Node root1, Node root2){
        if(root1==null && root2==null) return true;
         if(root1==null || root2==null) return false;
         boolean left=false;
         boolean right=false;
         if(root1.data==root2.data){
             left=solve(root1.left,root2.left);
             right=solve(root1.right,root2.right);
         }
         return left&&right;
    }
}
