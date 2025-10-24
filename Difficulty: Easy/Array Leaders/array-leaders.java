class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n=arr.length;
         ArrayList<Integer> list=new ArrayList<>();
          int max=-1;
         for(int i=n-1;i>=0;i--){
             if(arr[i]>=max){
                 max=arr[i];
                 list.add(max);
             }
         }
          Collections.reverse(list);
         return list;
    }
}
