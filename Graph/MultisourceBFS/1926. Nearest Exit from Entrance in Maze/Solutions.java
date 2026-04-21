/*
| Approach                                                                         | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Multi-source BFS from all boundary exits → reach entrance (reverse thinking)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if((maze[i][j]!='+') && (entrance[0]!=i || entrance[1]!=j)){
                        q.offer(new int[]{i,j});
                        maze[i][j]='+';
                    }
                }
            }
        }
        int level=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                if(i==entrance[0] && j==entrance[1]) return level;
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i>=0 && new_i<m && new_j>=0 & new_j<n && maze[new_i][new_j]=='.'){
                        q.offer(new int[]{new_i,new_j});
                        maze[new_i][new_j]='+';
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
