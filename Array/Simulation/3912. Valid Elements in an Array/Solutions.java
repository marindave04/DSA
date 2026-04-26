/*
| Approach                                                                                                     | Time Complexity | Space Complexity                   |
| ------------------------------------------------------------------------------------------------------------ | --------------- | ---------------------------------- |
| For each middle element, check all left and all right elements to verify validity, always include first/last | **O(n²)**       | **O(1)** *(excluding output list)* |

*/
class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        if(nums.length==1) return list;
       for(int i=1;i<nums.length-1;i++){
           int temp=nums[i];
           boolean flag=true;
           for(int j=0;j<i;j++){
               if(nums[j]>=temp){
                   flag=false;
                   break;
               }
           }
           if(flag){
               list.add(temp);
           }else{
               flag=true;
               for(int j=i+1;j<nums.length;j++){
                   if(nums[j]>=temp){
                       flag=false;
                       break;
                   }
               }
               if(flag){
                   list.add(temp);
               }
           }
       }
        list.add(nums[nums.length-1]);
        return list;
    }
}
