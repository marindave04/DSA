/*
| Approach                                                                                                  | Time     | Space    |
| --------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Build forest using adjacency list, run DFS from every root node, and track maximum depth among all trees. | **O(N)** | **O(N)** |

*/
import java.util.*;
public class Main{
    static int ans=0;
    static void dfs(int u,int depth,ArrayList<ArrayList<Integer>> adj){
        ans=Math.max(ans,depth);
        for(int v:adj.get(u)){
            dfs(v,depth+1,adj);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> roots=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int p=sc.nextInt();
            if(p==-1){
                roots.add(i);
            }else{
                adj.get(p).add(i);
            }
        }
        for(int root:roots){
            dfs(root,1,adj);
        }
        System.out.println(ans);
    }
}
