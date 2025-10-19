class Solution {

    void printGfg(int N) {
        // code here
        print(N);
    }
    static void print(int N){
        if(N==0) return;
        System.out.print("GFG"+" ");
        print(N-1);
    }
}