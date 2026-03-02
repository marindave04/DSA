class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        
        int i=0;
        int j=arr2.length-1;
        int min=Integer.MAX_VALUE;
        while(i<arr1.length && j>=0){
           int sum=arr1[i]+arr2[j];
           int diff=Math.abs(sum-x);
           if(diff<min){
               list.clear();
               list.add(arr1[i]);
               list.add(arr2[j]);
               min=diff;
           }
           if(sum>x){
               j--;
           }else{
               i++;
           }
        }
        return list;
    }
}
