//Time Complexity->O(n)
// Space Complexity -> 0(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lsize=q.size();
            List<Integer> list=new ArrayList<>();
           for(int i=0;i<lsize;i++){
            TreeNode curr=q.poll();
            list.add(curr.val);
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
           }
           result.add(list);
        }
        return result;
    }
}
