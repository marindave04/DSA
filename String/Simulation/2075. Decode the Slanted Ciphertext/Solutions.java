/*
| Approach                                       | Time Complexity | Space Complexity |
| ---------------------------------------------- | --------------- | ---------------- |
| **Matrix Reconstruction + Diagonal Traversal** | **O(n)**        | **O(n)**         |

*/
class Solution {
    public String decodeCiphertext(String str, int rows) {
        if(rows==1) return str;
        int l=str.length();
        int cols=l/rows;
        char[][] mat=new char[rows][cols];
        int idx=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j]=str.charAt(idx++);
            }
        } 
        StringBuilder sb=new StringBuilder();
        for(int c=0;c<cols;c++){
            int i=0;
            int j=c;
            while(i<rows && j<cols){
                sb.append(mat[i][j]);
                i++;
                j++;
            }
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
