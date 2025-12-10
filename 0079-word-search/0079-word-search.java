class Solution {
    static int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && find(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean find(char[][] board,int i,int j,int idx,String word){
        if(idx==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='$'){
            return false;
        }
        if(board[i][j]!=word.charAt(idx)) return false;
        char temp=board[i][j];
        board[i][j]='$';
        for(int[] dir:direction){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            if(find(board,new_i,new_j,idx+1,word)){
                return true;
            }
        }
        board[i][j]=temp;
        return false;

    }
}