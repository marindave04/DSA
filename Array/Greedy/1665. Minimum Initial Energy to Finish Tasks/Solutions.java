/*
| Approach                                                                                                                         | Time           | Space    |
| -------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Sort tasks by descending `(minimum - actual)` difference, then greedily maintain minimum required energy while processing tasks. | **O(N log N)** | **O(1)** |

*/
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->{
            int l1=Math.abs(a[1]-a[0]);
            int l2=Math.abs(b[1]-b[0]);
            return l2-l1;
        });
        int min=0;
        for(int[] row:tasks){
            min+=row[0];
        }
        int extra=0;
        int temp=min;
        for(int[] row:tasks){
            if(min>=row[1]){
                min=min-row[0];
            }else{
                extra=extra+row[1]-min;
                min=min+(row[1]-min);
                min=min-row[0];
            }
        }
        return temp+extra;
    }
}
