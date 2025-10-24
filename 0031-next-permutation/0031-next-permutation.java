class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 1st find gola from right i.e end of the array
        int gola = -1;
        for (int j = n - 1; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {
                gola = j - 1;
                break;
            }
        }

        // 2nd find element just greater than nums[gola] and swap
        if (gola >= 0) {
            for (int i = n - 1; i > gola; i--) {
                if (nums[i] > nums[gola]) {
                    swap(nums, gola, i);
                    break;
                }
            }
        }

        // 3rd reverse nums from gola+1 to n-1
        rev(nums, gola + 1, n - 1);
    }

    // helper to swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // helper to reverse a portion of array
    private void rev(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
