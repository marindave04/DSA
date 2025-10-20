class Solution {
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
     static void rev(char[] arr,int i,int j){
        if(i>j) {
           return ;
        }
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
     rev(arr,i+1,j-1);
    }
}