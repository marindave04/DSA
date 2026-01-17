class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea=0;
        int n=bottomLeft.length;
        for(int i=0;i<n;i++){
            int bottomLeftX_i=bottomLeft[i][0];
            int bottomLeftY_i=bottomLeft[i][1];  // square one
            int topRightX_i=topRight[i][0];
            int topRightY_i=topRight[i][1];
            for(int j=i+1;j<n;j++){
               int bottomLeftX_j=bottomLeft[j][0];
                int bottomLeftY_j=bottomLeft[j][1];
                int topRightX_j=topRight[j][0];
                int topRightY_j=topRight[j][1];
                if(topRightX_i <= bottomLeftX_j ||
                   topRightX_j <= bottomLeftX_i ||
                   topRightY_i <= bottomLeftY_j ||
                   topRightY_j <= bottomLeftY_i){
                    continue;
                }else{
                    int x1 =Math.min(topRightX_j,topRightX_i);
                    int y1=Math.min(topRightY_i,topRightY_j);
                    int x2=Math.max(bottomLeftX_j,bottomLeftX_i);
                    int y2=Math.max(bottomLeftY_j,bottomLeftY_i);
                    int width=Math.abs(x1-x2);
                    int height=Math.abs(y1-y2);
                    int l=Math.min(height,width);
                    long area=(long) l*l;
                    maxArea=(long)Math.max(maxArea,area);
                }
            }
        }
        return  maxArea;
    }
}