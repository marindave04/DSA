// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {
        // code here
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j){
            swap(arr,i,j);
            i++;
        }
        
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}