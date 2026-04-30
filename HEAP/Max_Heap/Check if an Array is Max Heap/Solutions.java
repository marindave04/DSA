/*
| Approach                                                                                                                                               | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------ | --------------- | ---------------- |
| Traverse array level-order style using parent index `i` and child pointer `j`, check every parent is greater than or equal to its at most two children | **O(n)**        | **O(1)**         |

*/
class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
        int n=arr.length;
        int i=0;
        int j=1;
        while(j<n){
            for(int p=1;p<=2;p++){
                if(j<n && arr[i]<arr[j]) return false;
                j++;
            }
            i++;
        }
        return true;
    }
}
