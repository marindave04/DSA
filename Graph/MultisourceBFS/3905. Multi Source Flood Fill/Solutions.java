/*
| Approach                                        | Time Complexity        | Space Complexity |
| ----------------------------------------------- | ---------------------- | ---------------- |
| **Multi-source BFS (Sorted by Color Priority)** | **O(n × m + k log k)** | **O(n × m)**     |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        Arrays.sort(sources, (a, b) -> b[2] - a[2]);
        for(int i=0;i<sources.length;i++){
            int r=sources[i][0];
            int c=sources[i][1];
            int color=sources[i][2];
            grid[r][c]=color;
            q.offer(new int[]{r,c,color});
        }
         
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                int color=curr[2];
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                     
                    if(new_i>=0 && new_i<n && new_j>=0 && new_j<m){
                        if(grid[new_i][new_j]==0){
                            grid[new_i][new_j]=color;
                            q.offer(new int[]{new_i,new_j,color});
                         
                        }
                        
                    }
                }
            }
        }
        return grid;
    }
}
