/*
| Approach                                                                                  | Time Complexity        | Space Complexity |
| ----------------------------------------------------------------------------------------- | ---------------------- | ---------------- |
| Implement stack using fixed-size array and top index pointer for push/pop/peek operations | **O(1)** per operation | **O(n)**         |

*/
class myStack {
    private int[] nums;
    private int idx=-1;
    public myStack(int n) {
        // Define Data Structures
        nums=new int[n];
    }

    public boolean isEmpty() {
        // check if the stack is empty
        if(idx==-1) return true;
        return false;
    }

    public boolean isFull() {
        // check if the stack is full
        if(idx==nums.length-1) return true;
        return false;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()) return;
        idx++;
        nums[idx]=x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()) return;
        nums[idx]=0;
        idx--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()) return -1;
        return nums[idx];
    }
}
