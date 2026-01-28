// Constraints:
// 1 ≤ arr.size() ≤ 40
// -107 ≤ arr[i], k ≤ 107

// Time Complexity: O(2 ^ (n/2))
// Auxiliary Space: O(n)

class Solution {

    public int countSubset(int[] arr, int k) {
        // code here
      int n=arr.length;
      int mid=n/2;
      int[] left=Arrays.copyOfRange(arr,0,mid);
      int[] right=Arrays.copyOfRange(arr,mid,n);
      
      //generate left array subset sum and store it in a map
      
      HashMap<Integer,Integer> map=new HashMap<>();
      generate(left,0,0,map);
      return countFromRight(right,0,0,map,k);
    }
    static void generate(int[] left,int i,int sum, HashMap<Integer,Integer> map){
        if(i>=left.length){
            map.put(sum,map.getOrDefault(sum,0)+1);
            return;
        }
        //take
        generate(left,i+1,sum+left[i],map);
        //skip
        generate(left,i+1,sum,map);
    }
    static int countFromRight(int[] right,int i,int sum,HashMap<Integer,Integer> map,int k){
        if(i>=right.length){
            return (map.getOrDefault(k-sum,0));
        }
        
        int take=countFromRight(right,i+1,sum+right[i],map,k);
        int skip=countFromRight(right,i+1,sum,map,k);
        return take+skip;
    }
}
