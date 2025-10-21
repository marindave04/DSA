class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        return sort(arr,0);
    }
    static boolean sort(int[] arr,int i){
        if(i==arr.length-1) return true;
        
        return (arr[i]<=arr[i+1] && sort(arr,i+1));
    }
}