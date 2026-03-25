/*
| Approach                                                                 | Time Complexity | Space Complexity             |
| ------------------------------------------------------------------------ | --------------- | ---------------------------- |
| **Brute Force (Check BST for every subtree + compute size recursively)** | **O(n²)**       | **O(h)** *(recursion stack)* |

*/
// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
       
      
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
       if(root==null) return 0;
       if(checkBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
           return size(root);
       }
       return Math.max(largestBst(root.left),largestBst(root.right));
    }
    static boolean checkBst(Node root,int min,int max){
        if(root==null) return true;
        if(root.data<=min || root.data>=max) return false;
        return( checkBst(root.left,min,root.data) && checkBst(root.right,root.data,max));
    }
    static int size(Node root){
        if(root==null) return 0;
        int l=size(root.left);
        int r=size(root.right);
        return l+r+1;
    }
}
/*
| Approach                                                                        | Time Complexity | Space Complexity             |
| ------------------------------------------------------------------------------- | --------------- | ---------------------------- |
| **Optimized DFS (Postorder) + Info class (Track min, max, size, BST validity)** | **O(n)**        | **O(h)** *(recursion stack)* |

*/
// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    static class Info{
        int max;
        int min;
        int size;
        boolean isBst;
        Info(int max,int min,int size,boolean isBst){
            this.max=max;
            this.min=min;
            this.size=size;
            this.isBst=isBst;
        }
    }
       
    static int maxSize;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
      maxSize=0;
      solve(root);
      return maxSize;
    }
    static Info solve(Node root){
        if(root==null) return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        Info left=solve(root.left);
        Info right=solve(root.right);
        if(left.isBst && right.isBst && root.data>left.max && root.data<right.min){
            int size=left.size+right.size+1;
            int max=Math.max(root.data,right.max);
            int min=Math.min(root.data,left.min);
            maxSize=Math.max(maxSize,size);
            return new Info(max,min,size,true);
        }
        return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,0,false);
    }
}
