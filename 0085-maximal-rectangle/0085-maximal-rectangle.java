class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        // ab hum is 2-d array ko 1-d array me convert krke krne ki koshish krenge uske liye ke 1-d height array lete hai phir each row ke liye cumulatively height array ko update krte rhenge
        int[] height=new int[n];
        //put first row in height array first
        for(int i=0;i<n;i++){
            height[i]=(matrix[0][i]=='1'? 1 : 0);
        }
        int maxArea= find(height);

        // ab hum height array ko hr ek row ke liye cumulatively update krenge
        for(int row=1;row<m;row++){
            for(int col=0;col<n;col++){
                if(matrix[row][col]=='0'){
                    height[col]=0;
                }else{
                    height[col]+=1;
                }
            }
            maxArea=Math.max(maxArea,find(height));
        }
        return maxArea;
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