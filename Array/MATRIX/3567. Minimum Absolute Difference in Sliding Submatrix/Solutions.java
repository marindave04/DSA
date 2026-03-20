/*
| Approach                                                                         | Time Complexity                    | Space Complexity |
| -------------------------------------------------------------------------------- | ---------------------------------- | ---------------- |
| **Brute Force (Extract k×k submatrix + sort + compute min adjacent difference)** | **O((m−k+1)·(n−k+1)·(k² log k²))** | **O(k²)**        |

*/
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ans=new int[m-k+1][n-k+1];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                int[] temp=new int[k*k];
                int idx=0;
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        temp[idx++]=grid[x][y];
                    }
                }
                Arrays.sort(temp);
                int min=Integer.MAX_VALUE;
                for(int p=0;p<temp.length-1;p++){
                    if(temp[p]==temp[p+1]) continue;
                    min=Math.min(min,(int)Math.abs(temp[p]-temp[p+1]));
                }
                if(min==Integer.MAX_VALUE) ans[i][j]=0;
                else ans[i][j]=min;
            }
        }
        return ans;
    }
}
