class Solution {

    void printNos(int N) {
        // code here
        print(N);
    }
    static void print(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        print(n-1);
    }
}