https://leetcode.com/problems/word-search/
class Solution {
    static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
       int m=board.length;
       int n=board[0].length;
       for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
           if(board[i][j]==word.charAt(0) && explore (board,i,j,0,word)){
             return true;
           }
    }
}
      return false;
    }
  static boolean explore(char[][] board,int i,int j,int idx,String word){
    if(idx==word.length()) return true;
    if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '#'){
      return false;
    }
    if(board[i][j] != word.charAt(idx)) return false;
    char temp=board[i][j];
    board[i][j]='#';
    for(int[] row:dir){
      int I=i+row[0];
      int J=j+row[1];
      if(explore(board,I,J,idx+1,word)){
        return true;
      }
    }
    board[i][j]=temp;
    return false;
  }
}
