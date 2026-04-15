/*
| Approach                                                      | Time Complexity | Space Complexity |
| ------------------------------------------------------------- | --------------- | ---------------- |
| **Circular Traversal (Forward & Backward Search for Target)** | **O(n)**        | **O(1)**         |

*/
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                flag = true;
                break;
            }
        }
        if (!flag) return -1;
        int step = 0;
        int min = Integer.MAX_VALUE;
        int i = startIndex;
        while (!words[(i) % n].equals(target)) {
            step++;
            i++;
        }
        i =startIndex;
        int step2 = 0;
        while (!words[(i + n) % n].equals(target)) {
            step2++;
            min = Math.min(min, step);
            i--;
        }
        return Math.min(step,step2);
    }
}
