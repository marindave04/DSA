class Solution {
    public boolean isPalindrome(String s) {
        String str=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr=str.toCharArray();
        if(str.equals(rev(arr,0,arr.length-1))) return true;
        return false;
    }
    static String rev(char[] arr,int i,int j){
        if(i>j) {
            String result = new String(arr);
            return result;
        }
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return rev(arr,i+1,j-1);
    }
}