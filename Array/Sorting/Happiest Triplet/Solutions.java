class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int i=0;
        int j=0;
        int k=0;
        int x=0;
        int y=0;
        int z=0;
        int diff=Integer.MAX_VALUE;
        while(i<a.length && j<b.length && k<c.length){
            int max=Math.max(Math.max(a[i],b[j]),c[k]);
            int min=Math.min(Math.min(a[i],b[j]),c[k]);
            
            if(max-min<diff){
                diff=max-min;
                 x=max;
                y=(a[i]+b[j]+c[k])-(max+min);
                 z=min;
            }
            if(min==a[i]) i++;
            else if(min==b[j]) j++;
            else k++;
        }
        int[] ans=new int[3];
        ans[0]=x;
        ans[1]=y;
        ans[2]=z;
        return ans;
    }
}
