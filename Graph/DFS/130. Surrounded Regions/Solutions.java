/*
| Approach                                            | Time Complexity | Space Complexity |
| --------------------------------------------------- | --------------- | ---------------- |
| **DFS from Boundary (Mark Safe + Convert Regions)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j]=='O'){
                        dfs(board,i,j,m,n);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 && j!=0 && i!=m-1 && j!=n-1){
                    if(board[i][j]=='O'){
                        dfs2(board,i,j,m,n);
                    }
                }
            }
        }
      for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
    }
    static void dfs(char[][] board,int r,int c,int m,int n){
        board[r][c]='S';
        for(int[] dir:directions){
            int new_i=r+dir[0];
            int new_j=c+dir[1];
             if(new_i>=0 && new_j>=0 && new_i<=m-1 && new_j<=n-1 && board[new_i][new_j]=='O'){
                dfs(board,new_i,new_j,m,n);
             }
        }
    }
    static void dfs2(char[][] board,int r,int c,int m,int n){
        board[r][c]='X';
        for(int[] dir:directions){
            int new_i=r+dir[0];
            int new_j=c+dir[1];
             if(  new_i!=0 && new_j!=0 && new_i!=m-1 && new_j!=n-1 && board[new_i][new_j]=='O'){
                dfs2(board,new_i,new_j,m,n);
             }
        }
    }
}
