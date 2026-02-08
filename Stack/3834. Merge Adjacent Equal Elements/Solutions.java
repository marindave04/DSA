class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> list=new ArrayList<>();
        Stack<Long> st=new Stack();
        for(int i=0;i<nums.length;i++){
            long curr=nums[i];
            while(!st.isEmpty() && curr==st.peek()){
                long a=st.pop();
                curr=(long) curr+a;
            }
            st.push(curr);
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        return list;
    }
}
