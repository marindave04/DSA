/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private HashMap<TreeNode,TreeNode> map=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        solve(root);
         List<Integer> list=new ArrayList<>();
         bfs(target,k,list);
         return list;
    }
    private void solve(TreeNode root){
        if(root==null) return ;
        if(root.left!=null){
            map.put(root.left,root);
        }
        solve(root.left);
        if(root.right!=null){
            map.put(root.right,root);
        }
        solve(root.right);
    }
    private void bfs(TreeNode target,int k, List<Integer> list){
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        q.offer(target);
        set.add(target.val);
        while(!q.isEmpty()){
            int lsize=q.size();
            if(k==0) break;
            for(int i=0;i<lsize;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !set.contains(curr.left.val)){
                    q.add(curr.left);
                    set.add(curr.left.val);
                }
                if(curr.right!=null && !set.contains(curr.right.val)){
                    q.add(curr.right);
                    set.add(curr.right.val);
                }
                if(map.containsKey(curr) && !set.contains(map.get(curr).val)){
                    q.add(map.get(curr));
                    set.add(map.get(curr).val);
                }
          }
          k--;
        }
        while(!q.isEmpty()){
             TreeNode curr=q.poll();
             list.add(curr.val);
        }
    }
}
