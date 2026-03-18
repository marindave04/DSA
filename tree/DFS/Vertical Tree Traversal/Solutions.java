/*
| Approach                                                                       | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------ | --------------- | ---------------- |
| **DFS + TreeMap (HD mapping) + Sorting by level for Vertical Order Traversal** | **O(n log n)**  | **O(n)**         |

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
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        TreeMap<Integer, ArrayList<ArrayList<Integer>>> map=new TreeMap<>();
        solve(root,0,0,map);
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
         for(int hd:map.keySet()){
              ArrayList<ArrayList<Integer>> temp=map.get(hd);
              Collections.sort(temp,Comparator.comparingInt(a->a.get(1)));
               ArrayList<Integer> line=new ArrayList<>();
              for(ArrayList<Integer> list:temp){
                  line.add(list.get(0));
              }
              ans.add(line);
         }
         return ans;
    }
    static void solve(Node root,int hd,int lvl,  TreeMap<Integer, ArrayList<ArrayList<Integer>>> map){
        if(root==null) return;
         ArrayList<ArrayList<Integer>> line=map.getOrDefault(hd,new ArrayList<>());
        ArrayList<Integer> list=new ArrayList<>();
        list.add(root.data);
        list.add(lvl);
        line.add(list);
        map.put(hd,line);
       
        solve(root.left,hd-1,lvl+1,map);
        solve(root.right,hd+1,lvl+1,map);
    }
}
