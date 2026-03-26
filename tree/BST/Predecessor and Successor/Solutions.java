/*
| Approach                                                           | Time Complexity | Space Complexity             |
| ------------------------------------------------------------------ | --------------- | ---------------------------- |
| **Inorder Traversal (DFS) to find predecessor & successor in BST** | **O(n)**        | **O(h)** *(recursion stack)* |

*/
/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    static boolean flag1;
    static Node p;
    static Node s;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        flag1=false;
        p=null;
        s=null;
        ArrayList<Node> ans=new ArrayList<>();
       
        solve(root,key);
         ans.add(p);
         ans.add(s);
        return ans;
    }
    static void solve(Node root, int key){
        if(root==null) return;
        
        solve(root.left,key);
        if(root.data>key && flag1==false){
            flag1=true;
            s=root;
        }
        if(flag1==false && root.data<key){
            p=root;
        }
       
        solve(root.right,key);
    }
}
/*
| Approach                                                                  | Time Complexity                   | Space Complexity |
| ------------------------------------------------------------------------- | --------------------------------- | ---------------- |
| **Iterative BST Traversal (Separate search for predecessor & successor)** | **O(h)** *(avg), O(n) worst case* | **O(1)**         |

*/
/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
      Node pre=solve1(root,key);
      Node suc=solve2(root,key);
      return new ArrayList<>(Arrays.asList(pre,suc));
    }
    static Node solve1(Node root, int key){
        Node curr = null;
        while(root!=null){
            if(root.data<key){
                curr=root;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return curr;
    }
     static Node solve2(Node root, int key){
        Node curr = null;
        while(root!=null){
            if(root.data>key){
                curr=root;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return curr;
    }
}
