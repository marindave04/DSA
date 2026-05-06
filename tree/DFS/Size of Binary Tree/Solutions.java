/*
| Approach                                                                                                              | Time Complexity | Space Complexity         |
| --------------------------------------------------------------------------------------------------------------------- | --------------- | ------------------------ |
| Perform simple DFS recursion on binary tree, increment global counter for every visited node, return total node count | **O(n)**        | **O(h)** recursive stack |

*/
/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    static int count;
    public int getSize(Node root) {
        // code here
        count=0;
        solve(root);
        return count;
    }
    static void solve(Node root){
        if(root==null){
            return;
        }
        count++;
        solve(root.left);
        solve(root.right);
    }
}
