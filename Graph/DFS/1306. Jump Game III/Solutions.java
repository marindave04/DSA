/*
| Approach                                                                                              | Time     | Space    |
| ----------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use DFS with visited array to recursively jump left or right and check if any path reaches value `0`. | **O(N)** | **O(N)** |

*/
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited=new boolean[arr.length];
        return solve(arr,start,visited);
    }
    static boolean solve(int[] arr, int i,boolean[] visited){
        if(i<0 || i>=arr.length || visited[i]) return false;
        if(arr[i]==0) return true;
        visited[i]=true;
        boolean options1=solve(arr,i+arr[i],visited);
        boolean options2=solve(arr,i-arr[i],visited);
        return options1 || options2;
  }
}
