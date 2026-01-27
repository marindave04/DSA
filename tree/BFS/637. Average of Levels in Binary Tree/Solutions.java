//Time complexity - O(n);
//Space Complexity O(n);

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
         Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lsize=q.size();
            double sum=0;
           for(int i=0;i<lsize;i++){
            TreeNode curr=q.poll();
            sum=(double) sum+curr.val;
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
           }
           double avg=(double) sum/lsize;
           list.add(avg);
        }
        return list;
    }
}
