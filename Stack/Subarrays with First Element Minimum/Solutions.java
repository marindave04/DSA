//Naive Approach] With Recalculated Minimum - O(n3) Time and O(1) Space
class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            int min=arr[i];
            for(int j=i;j<arr.length;j++){
                boolean flag=true;
                for(int k=i;k<=j;k++){
                    if(arr[k]<min){
                        flag=false;
                        break;
                    }
                }
                if(flag)  count++;
            }
        }
        return count;
    }
}
//[Better Approach] With Running Minimum - O(n2) Time and O(1) Space
class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            int min=arr[i];
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min) break;
                else count++;
            }
        }
        return count;
    }
}
//[Efficient Approach] Using stack - O(n) Time and O(n) Space
class Solution {
    public int countSubarrays(int[] arr) {
        // code here
       Stack<Integer> st=new Stack<>();
       int count=0;
    int l=0;
       for(int i=arr.length-1;i>=0;i--){
         while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
             st.pop();
         }
         if(!st.isEmpty()){
             l=st.peek();
         }else{
             l=arr.length;
         }
         count+=(l-i);
         st.push(i);
       }
       return count;
    }
}
