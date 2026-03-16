/*
| Approach                                              | Time Complexity                          | Space Complexity                              |
| ----------------------------------------------------- | ---------------------------------------- | --------------------------------------------- |
| **DFS from every node (start new path at each node)** | **O(n²)** *(worst case for skewed tree)* | **O(h)** *(recursion stack, h = tree height)* |

*/
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int total=0;
    public int countAllPaths(Node root, int k) {
        
        // code here
      
        if(root==null) return 0;
        solve(root,k,0);
        countAllPaths(root.left,k);
        countAllPaths(root.right,k);
        return total;
    }
    private void solve(Node root,int k,int sum){
        if(root==null) return;
        sum=sum+root.data;
        if(sum==k) total++;
        
        solve(root.left,k,sum);
        solve(root.right,k,sum);
    }
}
/*
| Approach                                              | Time Complexity | Space Complexity |
| ----------------------------------------------------- | --------------- | ---------------- |
| **DFS + Prefix Sum with HashMap (Path Sum counting)** | **O(n)**        | **O(n)**         |

*/

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int total=0;
    public int countAllPaths(Node root, int k) {
        
        // code here
      
       
        HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0,1);
        solve(root,k,0,map);
        
        return total;
    }
    private void solve(Node root,int k,int sum, HashMap<Integer,Integer> map){
        if(root==null) return;
        sum=sum+root.data;
        if(map.containsKey(sum-k)){
            total=total+map.get(sum-k);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        solve(root.left,k,sum,map);
        solve(root.right,k,sum,map);
        map.put(sum,map.get(sum)-1);
    }
}
