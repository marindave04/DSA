class Solution {
    public int minNumberOperations(int[] target) {
        int prev=0;
        int op=0;
        for(int i=0;i<target.length;i++){
            int current=target[i];
            if(current>prev){
                op+=(current-prev);
            }
            prev=current;
        }
        return op;
   }
} 