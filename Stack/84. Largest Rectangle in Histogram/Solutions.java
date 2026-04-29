/*
| Approach                                                                                                                         | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| For every bar, expand linearly to left and right while adjacent bars are at least current height, compute area using total width | **O(n²)**       | **O(1)**         |

*/
class Solution {
    public int largestRectangleArea(int[] heights) {
       long max=Long.MIN_VALUE;
       int n=heights.length;
       for(int i=0;i<n;i++){
        int width=1;
        //going left
        int l=i-1;
        while(l>=0 && heights[l]>=heights[i]){
            width++;
            l--;
        }
        //going right
        int r=i+1;
        while(r<n && heights[r]>=heights[i]){
            width++;
            r++;
        }
        long area=(long) heights[i]*width;
        max=(long)Math.max(max,area);
       }
       return (int)max;
    }
}
/*
| Approach                                                                                                                                                          | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Use monotonic stack to find **Next Smaller to Right (NSR)** and **Next Smaller to Left (NSL)** for each bar, then compute width = NSR - NSL - 1 and maximize area | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int largestRectangleArea(int[] heights) {
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
