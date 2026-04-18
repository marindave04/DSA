/*
| Approach                                               | Time Complexity | Space Complexity |
| ------------------------------------------------------ | --------------- | ---------------- |
| **Multi-DFS + Memoization (3 Independent Traversals)** | **O(n²)**       | **O(n²)**        |

*/
class Solution {
    static int n;
    static int[][] t1=new int[1001][1001];
    public int maxCollectedFruits(int[][] fruits) {
        n=fruits.length;
        for(int[] row:t1){
            Arrays.fill(row,-1);
        }
        int ans=child1(fruits,0,0)+child2(fruits,0,n-1)+child3(fruits,n-1,0);
        return ans;
    }
    static int child1(int[][] grid,int i,int j){
        if(i==n-1 && j==n-1) return grid[i][j];
        int temp=0;
        if(i+1<n && j+1<n){
          temp=grid[i][j]+child1(grid,i+1,j+1);
        }
        return temp;
    }
     static int child2(int[][] grid,int i,int j){
        if(i>=n || j>=n || j<0) return 0;
        if(i==n-1 && j==n-1) return 0;
        if(i==j || i>j ) return 0;
        if(t1[i][j]!=-1) return t1[i][j];
        int path1=grid[i][j]+child2(grid,i+1,j-1);
        int path2=grid[i][j]+child2(grid,i+1,j);
        int path3=grid[i][j]+child2(grid,i+1,j+1);
        return t1[i][j]=Math.max(path1,Math.max(path2,path3));
    }
     static int child3(int[][] grid,int i,int j){
        if(i>=n || j>=n || i<0) return 0;
        if(i==n-1 && j==n-1) return 0;
        if(i==j || i<j ) return 0;
        if(t1[i][j]!=-1) return t1[i][j];
        int path1=grid[i][j]+child3(grid,i-1,j+1);
        int path2=grid[i][j]+child3(grid,i,j+1);
        int path3=grid[i][j]+child3(grid,i+1,j+1);
        return t1[i][j]=Math.max(path1,Math.max(path2,path3));
    }
}
