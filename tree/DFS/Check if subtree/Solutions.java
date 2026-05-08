/*
| Approach                                                                                                                                                       | Time Complexity | Space Complexity               |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ------------------------------ |
| For every node of first tree, recursively check whether both trees are structurally identical with same node values; if not, search in left and right subtrees | **O(n × m)**    | **O(h₁ + h₂)** recursive stack |

*/
/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        if(root2==null) return true;
        if(root1==null) return false;
        if(solve(root1,root2)) return true;
        boolean left=isSubTree(root1.left,root2);
        boolean right=isSubTree(root1.right,root2);
        return left||right;
    }
    static boolean solve(Node root1, Node root2){
        if(root1==null && root2==null) return true;
         if(root1==null || root2==null) return false;
         boolean left=false;
         boolean right=false;
         if(root1.data==root2.data){
             left=solve(root1.left,root2.left);
             right=solve(root1.right,root2.right);
         }
         return left&&right;
    }
}
/*
| Approach                                                                                                                                                              | Time Complexity                                                     | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- | ---------------- |
| Serialize both trees using preorder traversal with null markers (`*`), then check whether serialized subtree string exists inside main tree string using `contains()` | **O(n + m)** average *(can degrade to O(n·m) for substring search)* | **O(n + m)**     |

*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        solve(root1,sb1);
        solve(root2,sb2);
        String s1=sb1.toString();
        String s2=sb2.toString();
        return s1.contains(s2);
    }
    static void solve(Node root, StringBuilder sb){
        if(root==null){
            sb.append('*');
            return;
        }
        sb.append(root.data).append("");
        solve(root.left,sb);
        solve(root.right,sb);
    }
}
/*
| Approach                                                                                                                                                                           | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Serialize both trees using preorder traversal with null markers, build LPS array for subtree serialization, then apply KMP pattern matching to check subtree existence efficiently | **O(n + m)**    | **O(n + m)**     |

*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        solve(root1,sb1);
        solve(root2,sb2);
        String s1=sb1.toString();
        String s2=sb2.toString();
        int[] lps=findLps(s2);
        int n=s1.length();
        int m=s2.length();
        int i=0;
        int j=0;
        while(i<n){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
                if(j>=m) return true;
            }else if(j>0){
                j=lps[j-1];
            }else{
                i++;
            }
        }
        return false;
    }
    static int[] findLps(String pattern){
        int n=pattern.length();
        int[] lps=new int[n];
        lps[0]=0;
        int len=0;
        int i=1;
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    static void solve(Node root, StringBuilder sb){
        if(root==null){
            sb.append('*');
            return;
        }
        sb.append(root.data).append("");
        solve(root.left,sb);
        solve(root.right,sb);
    }
}
