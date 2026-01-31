// linear search
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char ch: letters){
            if(ch-'a'>target-'a'){
               return ch;
            }
        }
        return letters[0];
    }
}
//BinarySearch
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       int low=0;
       int high=letters.length-1;
       char ans=letters[0];
       while(low<=high){
        int mid=low+(high-low)/2;
        if(letters[mid]-'a'>target-'a'){
            ans=letters[mid];
            high=mid-1;
        }else{
            low=mid+1;
        }
       }
       return ans;
    }
}
