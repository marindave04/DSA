class Solution {
    public int largestRectangleArea(int[] heights) {
      int max=find(heights);
      return max;  
    }
    static int find(int[] height){
       int[] NSR=getNSR(height);
       int[] NSL=getNSL(height);
       int[] width=new int[height.length];
       for(int i=0;i<height.length;i++){
        width[i]=NSR[i]-NSL[i]-1;
       }
       int maxArea=0;
       for(int i=0;i<height.length;i++){
        int a=width[i]*height[i];
        maxArea=Math.max(maxArea,a);
       }
       return maxArea;
    }
    static int[] getNSR(int[] height){
       Stack<Integer> st=new Stack<>();
       int n=height.length;
       int[] NSR=new int[n];
       for(int i=n-1;i>=0;i--){
          if(st.isEmpty()){
            NSR[i]=n;
          }else{
            while(!st.isEmpty() && height[(st.peek())]>=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
            NSR[i]=n;
          } else {
            NSR[i]=st.peek();
          }
          }
         st.push(i);
       } 
       return NSR;
    }
    static int[] getNSL(int[] height){
          Stack<Integer> st=new Stack<>();
       int n=height.length;
       int[] NSL=new int[n];
       for(int i=0;i<n;i++){
          if(st.isEmpty()){
            NSL[i]=-1;
          }else{
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
            NSL[i]=-1;
          } else {
            NSL[i]=st.peek();
          }
          }
         st.push(i);
       } 
       return NSL;
    }
}