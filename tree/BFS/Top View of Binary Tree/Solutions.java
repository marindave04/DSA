/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| **BFS (Level Order Traversal) + Horizontal Distance Mapping using TreeMap** | **O(n log n)**  | **O(n)**         |

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
       Map<Integer,Integer> map=new TreeMap<>();
       Queue<Object[]> q=new LinkedList<>();
       q.offer(new Object[]{root,0});
       while(!q.isEmpty()){
           Object[] curr=q.poll();
           Node node=(Node)curr[0];
           int hd=(int)curr[1];
           if(!map.containsKey(hd)){
               map.put(hd,node.data);
           }
           if(node.left!=null){
               q.offer(new Object[]{node.left,hd-1});
           }
           if(node.right!=null){
               q.offer(new Object[]{node.right,hd+1});
           }
       }
       ArrayList<Integer> result=new ArrayList<>();
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           result.add(entry.getValue());
       }
       return result;
    }
}
/*
| Approach                         | Time Complexity |
| -------------------------------- | --------------- |
| TreeMap solution (tumhara pehla) | **O(N log N)**  |
| HashMap solution (ye wala)       | **O(N)**        |

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
class Pair{
    Node node;
    int hd;
    Pair(Node n,int h){
        node=n;
        hd=h;
    }
}
class Solution {
    
    public ArrayList<Integer> topView(Node root) {
        // code here
      HashMap<Integer,Integer> map=new HashMap<>();
      Queue<Pair> q=new LinkedList<>();
      q.offer(new Pair(root,0));
      int min=Integer.MAX_VALUE;
      while(!q.isEmpty()){
          Pair temp=q.poll();
          Node node=temp.node;
          int hd=temp.hd;
          min=Math.min(min,hd);
          if(!map.containsKey(hd)){
              map.put(hd,node.data);
          }
          if(node.left!=null) q.add(new Pair(node.left,hd-1));
          if(node.right!=null) q.add(new Pair(node.right,hd+1));
      }
      int max=Integer.MIN_VALUE;
      for(int key:map.keySet()){
          max=Math.max(max,key);
      }
      ArrayList<Integer> list=new ArrayList<>();
      for(int i=min;i<=max;i++){
          list.add(map.get(i));
      }
      return list;
    }
}
