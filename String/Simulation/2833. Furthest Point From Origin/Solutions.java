/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse string, treat '_' as both +1 and -1 to maximize distance, take max | **O(n)**        | **O(1)**         |

*/
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int temp1=0;
        int temp2=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='R'){
                temp1++;
                temp2++;
            }else if(moves.charAt(i)=='L'){
                temp1--;
                temp2--;
            }else {
                temp1++;
                temp2--;
            }
        }
        return Math.max(Math.abs(temp1),Math.abs(temp2));
    }
}
