class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
       
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(-1);
        }
        for(int i=0;i<arr.length;i++){
            
           while(!st.isEmpty() && arr[i]>arr[st.peek()]){
               list.set(st.peek(),arr[i]);
               st.pop();
           }
           
           st.push(i);
        }
       
        return list;
    }
}