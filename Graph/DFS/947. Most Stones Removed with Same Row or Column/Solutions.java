/*
| Approach                                                                   | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------- | --------------- | ---------------- |
| **DFS on n×n grid (scan full row + full column for each stone component)** | **O(n³)**       | **O(n²)**        |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    static int n;
    public int removeStones(int[][] stones) {
        n=Integer.MIN_VALUE;
        for(int i=0;i<stones.length;i++){
            n=Math.max(n,Math.max(stones[i][0],stones[i][1]));
        }
        n=n+1;
        int[][] grid=new int[n][n];
        for(int i=0;i<stones.length;i++){
            int r=stones[i][0];
            int c=stones[i][1];
            grid[r][c]=1;
        }
        int max=0;
        int key=1;
        boolean[][] visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                     HashMap<Integer,Integer> map=new HashMap<>();
                    
                    key++;
                    dfs(grid,i,j,visited,key,map);
                    
                    int sum=map.getOrDefault(key,0);
                   max=max+(sum-1);
                }
            }
        }
        return max;
    }
    static void dfs(int[][] grid,int r,int c,boolean[][] visited,int key,HashMap<Integer,Integer> map){
           
              if(grid[r][c]==1){
                  visited[r][c]=true;
                  map.put(key, map.getOrDefault(key,0)+1);
              } 
        
             //same row traverse
             for(int j=0;j<n;j++){
                if(grid[r][j]==1 && !visited[r][j]){
                    dfs(grid,r,j,visited,key,map);
                }
             }
             //same col traverse
             for(int i=0;i<n;i++){
                 if(grid[i][c]==1 && !visited[i][c]){
                    dfs(grid,i,c,visited,key,map);
                }
             }
    }
    
}
/*
| Approach                                                               | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------- | --------------- | ---------------- |
| **DFS on stones (checking all stones for same row/column connection)** | **O(n²)**       | **O(n)**         |

*/
class Solution {
    static int n;
    static HashMap<Integer,Integer> map;
    public int removeStones(int[][] stones) {
       n=stones.length;
       boolean[] visited=new boolean[n];
        map=new HashMap<>();
       int key=1;
       for(int i=0;i<n;i++){
        int r=stones[i][0];
        int c=stones[i][1];
        key++;
        if(!visited[i]){
          dfs(stones,r,c,key,visited);
        }
       }
       int sum=0;
       for(int it:map.values()){
        sum=sum+(it-1);
       }
       return sum;
    }
    static void dfs(int[][] stones,int r,int c,int key,boolean[] visited){
        
        for(int i=0;i<n;i++){
            if((r==stones[i][0]||c==stones[i][1]) && !visited[i]){
                map.put(key,map.getOrDefault(key,0)+1);
                visited[i]=true;
                dfs(stones,stones[i][0],stones[i][1],key,visited);
            }
        }
    }
}
