/*
| Approach                                                                        | Time Complexity | Space Complexity | Reason                                      |
| ------------------------------------------------------------------------------- | --------------- | ---------------- | ------------------------------------------- |
| Preorder traversal with `#` for null nodes and `split()` during deserialization | O(n)            | O(n)             | Each node and null marker is processed once |

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private StringBuilder sb=new StringBuilder();
    private int idx=0;
    private void solve(TreeNode root){
        if(root==null){
            sb.append('#').append(',');
            return;
        }
        sb.append(root.val).append(',');
        solve(root.left);
        solve(root.right);
    }
    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        solve(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] arr=data.split(",");
       return solve2(arr);
    }
    private TreeNode solve2(String[] arr){
        
         if(arr[idx].equals("#")){
            idx++;
            return null;
        }
        String str=arr[idx++];
        int val=Integer.valueOf(str);
        TreeNode root=new TreeNode(val);
        root.left=solve2(arr);
        root.right=solve2(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
