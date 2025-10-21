class Solution {
    public int search(int arr[], int x) {
        // code here
        return search1(arr,0,x);
    }
    static int search1(int[] arr,int i,int x){
        if(i==arr.length) return -1;
        if(arr[i]==x) return i;
        return search1(arr,i+1,x);
    }
}
