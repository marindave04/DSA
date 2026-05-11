/*
| Approach                                                                                                | Time           | Space          |
| ------------------------------------------------------------------------------------------------------- | -------------- | -------------- |
| Extract digits of each number, reverse to maintain order, append into list, then convert list to array. | **O(N log M)** | **O(N log M)** |

*/
class Solution {
    public int[] separateDigits(int[] nums) {
        //simulation
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
             ArrayList<Integer> temp=new ArrayList<>();
             while(nums[i]>0){
                int rem=nums[i]%10;
                temp.add(rem);
                nums[i]=nums[i]/10;
             }
             Collections.reverse(temp);
             list.addAll(temp);
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
