/*
| Approach                                                                                                                                           | Time     | Space    |
| -------------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Build the tree, find the maximum root-to-leaf height using DFS, then compute the answer using fast modular exponentiation (2^{(\text{height}-1)}). | **O(N)** | **O(N)** |

*/
class Solution {
    static final int mod=(int)1e9+7;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length;
       
        ArrayList<Integer>[] adj=new ArrayList[n+2];
        for(int i=0;i<n+2;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int height=dfs(adj,1,-1);
         int oddCount=(height+1)/2;
         int ans=pow(2,height-1);
         return ans;
    }
    static int dfs(ArrayList<Integer>[] adj,int u,int p){
        int height=0;
        for(int v:adj[u]){
            if(v!=p){
                height=Math.max(height,dfs(adj,v,u)+1);
            }
        }
        return height;
    }
    static int pow(int x,int y){
        long res=1;
        long base=x;
        while(y>0){
            if((y & 1)==1){
                res=(res*base)%mod;
            }
            base=(base*base)%mod;
            y=y>>1;
        }
        return (int) res;
    }
}
