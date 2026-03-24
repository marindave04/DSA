/*
| Approach                                                                         | Time Complexity | Space Complexity             |
| -------------------------------------------------------------------------------- | --------------- | ---------------------------- |
| **DFS (Postorder) + Greedy flow of excess candies (Distribute Candies in Tree)** | **O(n)**        | **O(h)** *(recursion stack)* |

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
    public int distCandy(Node root) {
        // code here
        //main idea behind this is if a node has 0 candy we should pull candy from parent node and if a 
        //node has more than one candy then we should push extra -1 candy to its parent
          int[] ans=new int[1];
          solve(root,ans);
          return ans[0];
    }
    static int solve(Node root,int[] ans){
        if(root==null) return 0;
        int l=solve(root.left,ans);
        int r=solve(root.right,ans);
        ans[0]+=Math.abs(l)+Math.abs(r);
        return l+r+root.data-1;
    }
}
