class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int l=0;
        int size=n-k;
        int r=0;
        int sumWindow=0;
        int totalSum=0;
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            totalSum+=cardPoints[i];
        }

        while(r<=size-1){
                sumWindow+=cardPoints[r];
                r++;
            }
           ans=Integer.max(ans,totalSum-sumWindow);

        while(r<n){
            sumWindow+=cardPoints[r];
            
            sumWindow-=cardPoints[l];
            l++;
            ans=Integer.max(ans,totalSum-sumWindow);
            
            r++;
            

        }

        return ans;
    }
}