class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        for(int i=1;i<arr.length;i++){
            int e=arr[i-1][1];
            int s=arr[i][0];
            if(s<e) return false;
        }
        return true;
    }
}
