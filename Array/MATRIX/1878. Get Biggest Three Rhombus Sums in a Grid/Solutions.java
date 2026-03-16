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
