/*
| Approach                                                                                                                                                        | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Build cumulative height matrix column-wise, treat each row as histogram, and for every histogram use NSL + NSR monotonic stack method to find largest rectangle | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] cumGrid=new int[m][n];
        for(int col=0;col<n;col++){
            for(int row=0;row<m;row++){
                if(row==0){
                    cumGrid[row][col]=matrix[row][col]-'0';
                }else{
                    if(matrix[row][col]-'0'==1){
                         cumGrid[row][col]= cumGrid[row-1][col]+matrix[row][col]-'0';
                    }else{
                       cumGrid[row][col]=0;
                    }
                }
            }
        }
       int max=0;
       for(int row=0;row<m;row++){
         int[] heights = cumGrid[row].clone();
         int area = largestRectangleArea(heights);
         max = Math.max(max, area);
       }
       return max;
    }
    static int largestRectangleArea(int[] heights) {
       long max=0;
       int n=heights.length;
       int[] NSR=new int[n];
       int[] NSL=new int[n];
       NSR=solve1(heights);
       NSL=solve2(heights);
       for(int i=0;i<n;i++){
        int width=NSR[i]-NSL[i]-1;
        long area=(long) heights[i]*width;
        max=(long)Math.max(max,area);
       }
       return (int)max;
    }
    static int[] solve1(int[] arr){
         int n=arr.length;
        int[] nums=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nums[i]=n;
            }else{
                nums[i]=st.peek();
            }
            st.push(i);
        }
        return nums;
    }
    static int[] solve2(int[] arr){
        int n=arr.length;
        int[] nums=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nums[i]=-1;
            }else{
                nums[i]=st.peek();
            }
            st.push(i);
        }
        return nums;
    }
}
