/*
| Approach                                                             | Time         | Space        |
| -------------------------------------------------------------------- | ------------ | ------------ |
| Extract each layer, rotate using reversal algorithm, then place back | **O(m × n)** | **O(m + n)** |

*/
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int layers=Math.min(m/2,n/2);
        for(int layer=0;layer<layers;layer++){
            ArrayList<Integer> list=new ArrayList<>();
            int top=layer;
            int bottom=m-layer-1;
            int left=layer;
            int right=n-layer-1;
            //top row(from left to right)
            for(int j=left;j<=right;j++){
                list.add(grid[top][j]);
            }
            //right column(from top+1 to bottom -1)
            for(int j=top+1;j<=bottom-1;j++){
                list.add(grid[j][right]);
            }
            //bottom row(from right to left)
            for(int j=right;j>=left;j--){
                list.add(grid[bottom][j]);
            }
            //left column(from bottom-1 to top+1)
            for(int j=bottom-1;j>=top+1;j--){
                list.add(grid[j][left]);
            }
            int len=list.size();
            int rotate=k%len;
            rev(list,0,len-1);
            rev(list,0,len-rotate-1);
            rev(list,len-rotate,len-1);
            int idx=0;
             //top row(from left to right)
            for(int j=left;j<=right;j++){
                grid[top][j]=list.get(idx);
                idx++;
            }
            //right column(from top+1 to bottom -1)
            for(int j=top+1;j<=bottom-1;j++){
                grid[j][right]=list.get(idx);
                idx++;
            }
            //bottom row(from right to left)
            for(int j=right;j>=left;j--){
                grid[bottom][j]=list.get(idx);
                idx++;
            }
            //left column(from bottom-1 to top+1)
            for(int j=bottom-1;j>=top+1;j--){
                grid[j][left]=list.get(idx);
                idx++;
            }
        }
        return grid;
    }
    static void rev(ArrayList<Integer> list,int s,int e){
        while(s<=e){
            int temp=list.get(s);
            list.set(s,list.get(e));
            list.set(e,temp);
            s++;
            e--;
        }
    }
}
