/*
| Approach                              | Time Complexity | Space Complexity |
| ------------------------------------- | --------------- | ---------------- |
| **Brute Force BFS from every 1-cell** | **O((m × n)²)** | **O(m × n)**     |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] updateMatrix(int[][] mat) {
        //1st question -we need to find nearest 0 for each cell let say 0-hospital,1-person so now question becomes nearest hospital for each person so one thing we can do is that we well run bfs for each person to get nearest hospital but tha will be n^2 * bfs which is inefficient so the best thing we can do is to run bfs or spred waves from hospital and look for nearest person that is actually multisource bfs .Now we will be solving this question though inefficient approach
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                }else{
                    ans[i][j]=bfs(i,j,mat);
                }
            }
        }
        return ans;
    }
    static int bfs(int r,int c,int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] visited=new boolean[m][n];
        visited[r][c]=true;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        int dist=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                if(mat[i][j]==0) return dist;
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && visited[new_i][new_j]==false){
                        visited[new_i][new_j]=true;
                        q.offer(new int[]{new_i,new_j});
                    }
                }
            }
            dist++;
        }
        return dist;
    }
}
/*
| Approach                       | Time Complexity | Space Complexity |
| ------------------------------ | --------------- | ---------------- |
| **Multi-source BFS (Optimal)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //1st question -we need to find nearest 0 for each cell let say 0-hospital,1-person so now question becomes nearest hospital for each person so one thing we can do is that we well run bfs for each person to get nearest hospital but tha will be n^2 * bfs which is inefficient so the best thing we can do is to run bfs or spred waves from hospital and look for nearest person that is actually multisource bfs 
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && mat[new_i][new_j]==-1){
                        mat[new_i][new_j]=mat[i][j]+1;
                        q.offer(new int[]{new_i,new_j});
                    }
                }
            }
        }
        return mat;
    }
}
