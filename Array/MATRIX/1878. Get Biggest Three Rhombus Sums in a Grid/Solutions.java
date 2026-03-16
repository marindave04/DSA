/*
| Approach                                                       | Time Complexity         | Space Complexity              |
| -------------------------------------------------------------- | ----------------------- | ----------------------------- |
| **Brute Force Rhombus Traversal + TreeSet to keep top 3 sums** | **O(m · n · min(m,n))** | **O(1)** *(TreeSet size ≤ 3)* |

*/
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        TreeSet<Integer> set=new TreeSet<>();
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                add(set,grid[r][c]);
                for(int side=1;(r-side>=0 && r+side<m && c-side>=0 && c+side<n);side++){
                    int sum=0;
                    for(int k=0;k<=side-1;k++){
                        sum+=grid[r-side+k][c+k];
                        sum+=grid[r+k][c+side-k];
                        sum+=grid[r+side-k][c-k];
                        sum+=grid[r-k][c-side+k];
                    }
                    add(set,sum);
                }
            }
        }
        return ans(set);
    }
    private void add(TreeSet<Integer> set,int sum){
        set.add(sum);
        if(set.size()>3){
            set.pollFirst();
        }
    }
    private int[] ans(TreeSet<Integer> set){
        int[] arr=new int[set.size()];
        Iterator<Integer>it=set.descendingIterator();
        int idx=0;
        while(it.hasNext()){
            arr[idx++]=it.next();
        }
        return arr;
    }
}
/*
| Approach                                                                      | Time Complexity         | Space Complexity |
| ----------------------------------------------------------------------------- | ----------------------- | ---------------- |
| **Diagonal Prefix Sum + Rhombus Boundary Calculation + TreeSet (Top 3 sums)** | **O(m · n · min(m,n))** | **O(m · n)**     |

*/
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] d1=new int[m][n];
        int[][] d2=new int[m][n];
        //populating cumulative diagonal sum;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                d1[i][j]=grid[i][j];
                if(i>0 && j>0){
                    d1[i][j]+=d1[i-1][j-1];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                d2[i][j]=grid[i][j];
                if(i>0 && j+1<n){
                    d2[i][j]+=d2[i-1][j+1];
                }
            }
        }
        TreeSet<Integer> set=new TreeSet<>();
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                add(set,grid[r][c]);
                for(int side=1;(r-side>=0 && r+side<m && c-side>=0 && c+side<n);side++){
                    int sum=0;
                    int top_r=r-side,top_c=c;
                    int right_r=r,right_c=c+side;
                    int bottom_r=r+side,bottom_c=c;
                    int left_r=r,left_c=c-side;
                    // top to right corner
                    sum += d1[right_r][right_c];
                    if (top_r-1 >= 0 && top_c-1 >= 0)
                        sum -= d1[top_r-1][top_c-1];

                    // right to bottom corner
                    sum += d2[bottom_r][bottom_c];
                    if (right_r-1 >= 0 && right_c+1 < n)
                        sum -= d2[right_r-1][right_c+1];

                    // bottom to left corner
                    sum += d1[bottom_r][bottom_c];
                    if (left_r-1 >= 0 && left_c-1 >= 0)
                        sum -= d1[left_r-1][left_c-1];

                    // left to top corner
                    sum += d2[left_r][left_c];
                    if (top_r-1 >= 0 && top_c+1 < n)
                        sum -= d2[top_r-1][top_c+1];

                    // remove corners counted twice
                    sum -= grid[top_r][top_c];
                    sum -= grid[right_r][right_c];
                    sum -= grid[bottom_r][bottom_c];
                    sum -= grid[left_r][left_c];
                     add(set,sum);
                    
                    
                }
            }
        }
        return ans(set);
    }
    private void add(TreeSet<Integer> set,int sum){
        set.add(sum);
        if(set.size()>3){
            set.pollFirst();
        }
    }
    private int[] ans(TreeSet<Integer> set){
        int[] arr=new int[set.size()];
        Iterator<Integer>it=set.descendingIterator();
        int idx=0;
        while(it.hasNext()){
            arr[idx++]=it.next();
        }
        return arr;
    }
}
