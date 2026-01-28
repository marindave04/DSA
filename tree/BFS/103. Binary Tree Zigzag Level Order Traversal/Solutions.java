class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> dq=new LinkedList<>();
        dq.offer(root);
        boolean flag=false;
        while(!dq.isEmpty()){
            int lsize=dq.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<lsize;i++){
              
                if(!flag){
                     TreeNode temp=dq.removeFirst();
                     list.add(temp.val);
                     if(temp.left!=null){
                        dq.addLast(temp.left);
                     }
                     if(temp.right!=null){
                        dq.addLast(temp.right);
                     }

                }else{// reverse wla case hai
                    TreeNode temp=dq.removeLast();
                     list.add(temp.val);
                     if(temp.right!=null){
                        dq.addFirst(temp.right);
                     }
                     if(temp.left!=null){
                        dq.addFirst(temp.left);
                     }
                     
                }
                
            }
            if(flag==false){
                    flag=true;
                }else{
                    flag=false;
                }
            result.add(list);
        }
        return result;
    }
}
