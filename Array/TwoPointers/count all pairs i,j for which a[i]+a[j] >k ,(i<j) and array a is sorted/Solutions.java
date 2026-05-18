/*
| Approach                                                                                                                             | Time     | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------ | -------- | -------- |
| Use two pointers on sorted array; when pair sum exceeds `k`, all elements between pointers with right element also form valid pairs. | **O(N)** | **O(1)** |

*/
import java.util.*;

public class Main {

    static long countPairs(int[] a, int k) {
        int n = a.length;

        int i = 0;
        int j = n - 1;

        long count = 0;

        while (i < j) {

            // if current pair sum > k
            if (a[i] + a[j] > k) {

                // all pairs from i to j-1 with j are valid
                count += (j - i);

                j--;
            } 
            else {
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int k = 5;

        System.out.println(countPairs(a, k));
    }
}
