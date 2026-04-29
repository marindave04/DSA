/*
| Approach                                                                                                                | Time Complexity                                    | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------- | ---------------- |
| Implement queue using array; enqueue at rear, dequeue by left shifting all elements, front at index `0`, rear at `top1` | **Enqueue: O(1), Dequeue: O(n), Front/Rear: O(1)** | **O(n)**         |

*/
class myQueue {

    // Constructor
    private int[] nums;
    int top1=-1;
    public myQueue(int n) {
        // Define Data Structures
        this.nums=new int[n];
    }

    public boolean isEmpty() {
        // Check if queue is empty
        if(top1==-1 ) return true;
        return false;
    }

    public boolean isFull() {
        // Check if queue is full
        if(top1==nums.length-1) return true;
        return false;
    }

    public void enqueue(int x) {
        // Enqueue
        if(isFull()) return;
        top1++;
        nums[top1]=x;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty()) return;
        for(int i=1;i<nums.length;i++){
            nums[i-1]=nums[i];
        }
        top1--;
    }

    public int getFront() {
        // Get front element
        if(isEmpty()) return -1;
        return nums[0];
    }

    public int getRear() {
        // Get last element
         if(isEmpty()) return -1;
         return nums[top1];
    }
}
