/*
| Approach                                                    | Time Complexity | Space Complexity |
| ----------------------------------------------------------- | --------------- | ---------------- |
| **LCA + DFS Path Building (Convert path to ‘U’, ‘L’, ‘R’)** | **O(n)**        | **O(h)**         |

*/
class Solution {
    public String getDirections(TreeNode root, int s, int e) {
       //finding lca
       TreeNode LCA=lowestCommonAncestor(root,s,e);
       //finding path from lca to s
        StringBuilder path1=new StringBuilder();
        //finding path from lca to e
        StringBuilder path2=new StringBuilder();
        solve(LCA,path1,s);
        solve(LCA,path2,e);
        for(int i=0;i<path1.length();i++){
            path1.setCharAt(i,'U');
        }
       return path1.toString()+path2.toString();
    }
    static boolean solve(TreeNode root,StringBuilder sb,int target){
        if(root==null) return false;
        if(root.val==target){
            return true;
        }
        sb.append('L');
        if(solve(root.left,sb,target)) return true;
         sb.deleteCharAt(sb.length()-1);
         sb.append('R');
        if(solve(root.right,sb,target)) return true;;
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
    static  TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root==null) return null;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(left!=null){
            if((root.val==p) ||( root.val==q)){
                return root;
            }else{
                return left;
            }
        }
        if(right!=null){
            if((root.val==p )|| (root.val==q)){
                return root;
            }else{
                return right;
            }
        }
        if(root.val==p || root.val==q) return root;
        return null;
    }
}
