/*
| Approach                                                        | Time Complexity | Space Complexity |
| --------------------------------------------------------------- | --------------- | ---------------- |
| **DFS Traversal + Horizontal Distance Mapping (using TreeMap)** | **O(n log n)**  | **O(n)**         |

*/
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer,int[]> map=new TreeMap<>(); // to store hd and level;
        dfs(root,0,0,map);
        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,int[]> entry:map.entrySet()){
            list.add(entry.getValue()[0]);
        }
        return list;
    }
    static void dfs(Node root,int hd,int level, Map<Integer,int[]> map){
        if(root==null) return;
        
        if(!map.containsKey(hd) || map.get(hd)[1]>level){
            map.put(hd,new int[]{root.data,level});
        }
        dfs(root.left,hd-1,level+1,map);
        dfs(root.right,hd+1,level+1,map);
    }
}
