class Solution {
    public boolean canReach(int[] arr, int start) {
       boolean[] visited=new boolean[arr.length];
       return solve(arr,start,visited); 
    }
    static boolean solve(int[] arr,int i,boolean[] visited){
        if(i<0 || i>=arr.length || visited[i]){
            return false;
        } 
        if(arr[i]==0){
            return true;
        }
        visited[i]=true;
         boolean a= solve(arr,i-arr[i],visited);
          boolean b=solve(arr,i+arr[i],visited);
       return (a||b);
    }
}