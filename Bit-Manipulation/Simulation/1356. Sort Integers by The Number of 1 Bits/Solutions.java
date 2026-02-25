//brute force tc-O(n^2)
class Solution {
    public int[] sortByBits(int[] arr) {
         int[] one=new int[arr.length];
         for(int i=0;i<arr.length;i++){
            int n=arr[i];
            while(n>0){
                int rem=n%2;
                if(rem==1) one[i]++;
                n=n/2;
            }
         }
         for(int i=0;i<one.length-1;i++){
            for(int j=0;j<one.length-i-1;j++){
                if(one[j]>one[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    int temp2=one[j];
                    one[j]=one[j+1];
                    one[j+1]=temp2;
                }else if(one[j]==one[j+1]){
                    if(arr[j]>arr[j+1]){
                         int temp3=arr[j];
                         arr[j]=arr[j+1];
                         arr[j+1]=temp3;
                    }
                }
            }
         }
         return arr;
    }
}
//using comparator
class Solution {
    public int[] sortByBits(int[] arr) {
        //we will convert primitive array to object arraybecause Arrays.sort() me custom comparator use karne ke liye object array (Integer[]) chahiye hota hai, primitive int[] nahi.
     Integer[] nums=Arrays.stream(arr).boxed().toArray(Integer[]::new);
     Comparator<Integer> comparator=new CustomComparator();
     Arrays.sort(nums,comparator);
     return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
class CustomComparator implements Comparator<Integer>{
    public int compare(Integer a,Integer b){
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a - b;
        }
        
        return Integer.bitCount(a) - Integer.bitCount(b);
    }
}
