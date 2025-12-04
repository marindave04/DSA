class Solution {
    public int countCollisions(String directions) {
       
        int[] arr = new int[directions.length()];

        for (int i = 0; i < directions.length(); i++) {
            char ch = directions.charAt(i);

            if (ch == 'R') arr[i] = 1;
            else if (ch == 'L') arr[i] = 2;
            else if (ch == 'S') arr[i] = 0;
        }
        int count=0;
        int i=0;
        int j=1;
        int temp=0;
        while(j<arr.length){
            if(arr[i]==1 && arr[j]==2){
                count+=2;
                arr[j]=0;
                count+=temp;
                temp=0;
            }else if(arr[i]==1 && arr[j]==0){
                count+=1;
                arr[j]=0;
                count+=temp;
                temp=0;
            }else if(arr[i]==0 && arr[j]==2){
                count+=1;
                arr[j]=0;
            }else if(arr[i]==1 && arr[j]==1){
                temp++;
            }
            i++;
            j++;
        }
        return count;
    }
}