class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();  // faster

        for (int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) list.add(-1);
            else list.add(st.peek());

            st.push(arr[i]);
        }

        Collections.reverse(list);
        return list;
    }
}
