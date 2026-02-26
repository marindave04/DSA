class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //child to parent mapping
         HashMap<Integer,Integer> map=new HashMap<>();
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
         }
         for(int i=0;i<n;i++){
            int node=i;
            int left=leftChild[i];
            int right=rightChild[i];
            if(left!=-1){
                adj.get(i).add(left);
                if(map.containsKey(left)) return false;
                map.put(left,i);
            }
            if(right!=-1){
                adj.get(i).add(right);
                if(map.containsKey(right)) return false;
                map.put(right,i);
            }
         }
         int root=-1;
         for(int i=0;i<n;i++){
            if(!map.containsKey(i)){
                if(root!=-1) return false;
                root=i;
            }
         }
         if(root==-1) return false;
          boolean[] visited = new boolean[n];
         
           int count=bfs(adj,root,visited);
           if(count==n) return true;
           return false;
    }
     static int bfs(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited){
        Queue<Integer> q= new LinkedList<>();
        q.offer(u);
        int count=1;
        visited[u]=true;
        while(!q.isEmpty()){
            u=q.poll();
            for(int v:adj.get(u)){
                if(!visited[v]){
                    q.add(v);
                    visited[v]=true;
                   count++;
                }
            }
        }
        return count;
    }
}
