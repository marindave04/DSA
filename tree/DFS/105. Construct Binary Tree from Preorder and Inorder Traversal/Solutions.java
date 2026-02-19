/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        if(pre.length==0){
            return null;
        }
        int x=pre[0];
        int idx=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==x) idx=i;
        }
        TreeNode root=new TreeNode(x);
        root.left= buildTree(Arrays.copyOfRange(pre,1,idx+1),Arrays.copyOfRange(in,0,idx));
        root.right= buildTree(Arrays.copyOfRange(pre,idx+1,pre.length),Arrays.copyOfRange(in,idx+1,in.length));
        return root;
    }
}
//divide and conquer and without hasmap with TC->O(N^2);
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
       int[] index=new int[]{0};
       return solve(pre,in,0,in.length-1,index);
    }
    static TreeNode solve(int[] pre,int[] in,int l,int r,int[] index){
        if(l>r || index[0]>=pre.length) return null;
        int pos=l;
        while(pos<in.length && in[pos]!=pre[index[0]]) pos++;
        TreeNode root=new TreeNode(pre[index[0]++]);
        root.left=solve(pre,in,l,pos-1,index);
        root.right=solve(pre,in,pos+1,r,index);
        return root;
    }
}
//divide and conquer and with hasmap with TC->O(N);
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
       int[] index=new int[]{0};
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<in.length;i++){
        map.put(in[i],i);
       }
       return solve(pre,in,0,in.length-1,index,map);
    }
    static TreeNode solve(int[] pre,int[] in,int l,int r,int[] index,   HashMap<Integer,Integer> map){
        if(l>r || index[0]>=pre.length) return null;
        int pos=l;
        if(map.containsKey(pre[index[0]])){
           pos=map.get(pre[index[0]]);
        }
        TreeNode root=new TreeNode(pre[index[0]++]);
        root.left=solve(pre,in,l,pos-1,index,map);
        root.right=solve(pre,in,pos+1,r,index,map);
        return root;
    }
}
